package com.example.hfe;

public class Mumbai_Zone {

    String Discipline_Systems_of_Medicine,District,Emergency_Num,
            Facilities;
    long HID;
    String Hospital_Care_Type,Hospital_Category,
            Hospital_Name,Location,Location_Coordinates;
    long Pincode;
    String Specialties,State,Website;

    public Mumbai_Zone() {
    }

    public Mumbai_Zone(String discipline_Systems_of_Medicine, String district, String emergency_Num, String facilities, long HID, String hospital_Care_Type, String hospital_Category, String hospital_Name, String location, String location_Coordinates, long pincode, String specialties, String state, String website) {
        Discipline_Systems_of_Medicine = discipline_Systems_of_Medicine;
        District = district;
        Emergency_Num = emergency_Num;
        Facilities = facilities;
        this.HID = HID;
        Hospital_Care_Type = hospital_Care_Type;
        Hospital_Category = hospital_Category;
        Hospital_Name = hospital_Name;
        Location = location;
        Location_Coordinates = location_Coordinates;
        Pincode = pincode;
        Specialties = specialties;
        State = state;
        Website = website;
    }

    public String getDiscipline_Systems_of_Medicine() {
        return Discipline_Systems_of_Medicine;
    }

    public void setDiscipline_Systems_of_Medicine(String discipline_Systems_of_Medicine) {
        Discipline_Systems_of_Medicine = discipline_Systems_of_Medicine;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getEmergency_Num() {
        return Emergency_Num;
    }

    public void setEmergency_Num(String emergency_Num) {
        Emergency_Num = emergency_Num;
    }

    public String getFacilities() {
        return Facilities;
    }

    public void setFacilities(String facilities) {
        Facilities = facilities;
    }

    public long getHID() {
        return HID;
    }

    public void setHID(long HID) {
        this.HID = HID;
    }

    public String getHospital_Care_Type() {
        return Hospital_Care_Type;
    }

    public void setHospital_Care_Type(String hospital_Care_Type) {
        Hospital_Care_Type = hospital_Care_Type;
    }

    public String getHospital_Category() {
        return Hospital_Category;
    }

    public void setHospital_Category(String hospital_Category) {
        Hospital_Category = hospital_Category;
    }

    public String getHospital_Name() {
        return Hospital_Name;
    }

    public void setHospital_Name(String hospital_Name) {
        Hospital_Name = hospital_Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getLocation_Coordinates() {
        return Location_Coordinates;
    }

    public void setLocation_Coordinates(String location_Coordinates) {
        Location_Coordinates = location_Coordinates;
    }

    public long getPincode() {
        return Pincode;
    }

    public void setPincode(long pincode) {
        Pincode = pincode;
    }

    public String getSpecialties() {
        return Specialties;
    }

    public void setSpecialties(String specialties) {
        Specialties = specialties;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
