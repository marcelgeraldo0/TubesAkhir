package com.example.tubesakhir.Services;

import com.example.tubesakhir.MainActivity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Fetch extends AsyncTask<Void,Void,Void> {
    String source = "";
    String vehicle = "";
    String destination = "";
    String date = "";
    String hour ="";
    String course_id = "";
    String seats = "";
    String num_seats = "";
    String errcode = "";
    String message = "";
    String payload = "";
    String order_id = "";
    String order_datetime = "";
    String course_datetime = "";
    String fee = "";
    String offset = "";
    String limit = "";
    int totalCase = 0;
    int totalActive = 0;
    int totalDeath = 0;
    int totalRecovered = 0;

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.COUNTRY_NAME = country.toUpperCase();
        MainActivity.COUNTRY_CODE = countryCode;
        MainActivity.TOTAL_ACTIVE = totalActive;
        MainActivity.TOTAL_DEATH = totalDeath;
        MainActivity.TOTAL_RECOVERED = totalRecovered;
        if (feature.equalsIgnoreCase("summary")) {
            if (country.equalsIgnoreCase("global")) {
                MainActivity.changeWorld();
            } else  if (status.equalsIgnoreCase("ranking")) {
                MainActivity.changeRanking();
            } else {
                MainActivity.changeBy();
            }
        }
        else if (feature.equalsIgnoreCase("summary_live")) {
            if (!country.equalsIgnoreCase("")) {
                MainActivity.changeByLive();
            } else {
                MainActivity.changeWorld();
            }
        }

    }

    public void setCountry(String country) {
        this.country = country;
        System.out.println(this.country);
    }

    public void setFrom(String tanggal, String bulan, String tahun) {
        this.tanggal_from = tanggal;
        this.bulan_from = bulan;
        this.tahun_from = tahun;
    }

    public void setTo(String tanggal, String bulan, String tahun) {
        this.tanggal_to = tanggal;
        this.bulan_to = bulan;
        this.tahun_to = tahun;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPath() {
        if (feature.equals("country")) {
            this.path = "/countries";
        }
        else if (feature.equals("dayone")) {
            this.path += "/dayone/country" + "/" + country + "/status";
            if (status.equals("confirmed")) {
                this.path += "/confirmed";
            }
            else if (status.equals("deaths")) {
                this.path += "/deaths";
            }
            else if (status.equals("recovered")) {
                this.path += "/recovered";
            }
        } else if(feature.equals("summary")) {
            this.path += "/summary";
        } else if(feature.equals("summary_live")) {
            this.path += "/country" + "/" + this.country  + "/status/confirmed?from=" + this.tahun_from + "-" +
                    this.bulan_from + "-" + this.tanggal_from + "T00:00:00Z&to=" + this.tahun_to + "-" + this.bulan_to + "-" +
                    this.tanggal_to + "T00:00:00Z";
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            setPath();
            URL url = new URL("https://documenter.getpostman.com/view/471683/UVJckwjN" + this.path + "\n");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            Object JA;
            if (feature.equalsIgnoreCase("summary")) {
                JA = new JSONObject(data);
            } else {
                JA = new JSONArray(data);
            }
            if (feature.equals("dayone")) {
                JSONArray jADayone = (JSONArray) JA;
                for (int i = 0; i < jADayone.length(); i++) {
                    JSONObject jADayoneObj = jADayone.getJSONObject(i);
                    singleParsed = "Country Name:" + jADayoneObj.get("Country") + "\n" +
                            "Cases:" + jADayoneObj.get("Cases") + "\n" +
                            "Date:" + jADayoneObj.get("Date") + "\n";
                    Log.d("PARSED : " ,dataParsed = dataParsed + singleParsed + "\n");
                }
            } else if (feature.equals("summary_live")) {
                JSONArray jALive = (JSONArray) JA;
                for (int i = 0; i < jALive.length(); i++) {
                    JSONObject jOLive = jALive.getJSONObject(i);
                    totalActive += jOLive.getInt("Cases");
                    countryCode = jOLive.get("CountryCode").toString();
                }
            } else if (feature.equals("summary")) {
                JSONObject jOSummary = (JSONObject) JA;
                JSONArray jOCountries = jOSummary.getJSONArray("Countries");
                for (int i = 0; i < jOCountries.length(); i++) {
                    JSONObject jOTest = jOCountries.getJSONObject(i);
                    if (jOTest.get("Slug").toString().equalsIgnoreCase(country)) {
                        countryName = jOTest.get("Country").toString();
                        slug = jOTest.get("Slug").toString();
                        countryCode = jOTest.get("CountryCode").toString();
                        totalActive += jOTest.getInt("TotalConfirmed");
                        totalDeath += jOTest.getInt("TotalDeaths");
                        totalRecovered += jOTest.getInt("TotalRecovered");
                        totalCase = totalActive + totalDeath + totalRecovered;
                        break;
                    } else  if (country.equalsIgnoreCase("global")){
                        JSONObject jOGlobal = (JSONObject)jOSummary.get("Global");
                        totalActive += jOGlobal.getInt("TotalConfirmed");
                        totalDeath += jOGlobal.getInt("TotalDeaths");
                        totalRecovered += jOGlobal.getInt("TotalRecovered");
                        totalCase = totalActive + totalDeath + totalRecovered;
                        break;
                    } else if (status.equalsIgnoreCase("ranking")) {
                        System.out.println("MASUK KE RANKING COK");
                        countryName = jOTest.get("Country").toString();
                        slug = jOTest.get("Slug").toString();
                        countryCode = jOTest.get("CountryCode").toString();
                        totalActive += jOTest.getInt("TotalConfirmed");
                        System.out.println(totalActive);
                        totalDeath += jOTest.getInt("TotalDeaths");
                        totalRecovered += jOTest.getInt("TotalRecovered");
                        totalCase = totalActive + totalDeath + totalRecovered;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

