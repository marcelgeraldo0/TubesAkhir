package com.example.tubesakhir.repositories;

import androidx.lifecycle.MutableLiveData;
import com.example.tubesakhir.Model.Course;
import java.util.ArrayList;
import java.util.List;


public class CourseRepository {

    private static CourseRepository instance;
    private ArrayList<Course> dataSet = new ArrayList<>();

    public static CourseRepository getInstance() {
        if(instance == null) {
            instance = new CourseRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Course>> getCountries() {
        MutableLiveData<List<Course>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public void setCountries(String countryName, String slug, String iso2) {
        dataSet.add(new Course());
    }
}