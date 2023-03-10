package com.ayesha.judicial_provision.Lawyers_Portal;

import java.util.ArrayList;
import java.util.List;

public class LawyerDataSet {
    private List<lawyer> dataset = new ArrayList<>();
    public List<lawyer> getData(){

        dataset.add(new lawyer("Ali","0300xxxxxxx","Civil"));
        dataset.add(new lawyer("Ahmed","0300xxxxxxx","Civil"));
        dataset.add(new lawyer("Asfand","0300xxxxxxx","Cyber"));
        dataset.add(new lawyer("Qaiser","0300xxxxxxx","Traffic"));
        dataset.add(new lawyer("Kanwal","0300xxxxxxx","Intellectual Property Rights"));
        dataset.add(new lawyer("Ali Ahmed","0300xxxxxxx","Murders"));
        dataset.add(new lawyer("Shavaiz","0300xxxxxxx","Terrorism"));
        dataset.add(new lawyer("Naima","0300xxxxxxx","Woman Rights"));
        dataset.add(new lawyer("Rubab","0300xxxxxxx","Black Mailing"));
        dataset.add(new lawyer("Nouman","0300xxxxxxx","Sexusal Harresment"));
        dataset.add(new lawyer("Mehmat","0300xxxxxxx","Cyber Stalking"));
        return dataset;
    }

}
