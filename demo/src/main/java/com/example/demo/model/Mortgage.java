package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "preliminary") // Replace with your actual table name
public class Mortgage {

    @Id
    @Column(name = "sequence_number")
    private String sequenceNumber; // Primary key

    @Column(name = "as_of_year")
    private String asOfYear;

    @Column(name = "respondent_id")
    private String respondentId;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "agency_abbr")
    private String agencyAbbr;

    @Column(name = "agency_code")
    private String agencyCode;

    @Column(name = "loan_type_name")
    private String loanTypeName;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "property_type_name")
    private String propertyTypeName;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "loan_purpose_name")
    private String loanPurposeName;

    @Column(name = "loan_purpose")
    private String loanPurpose;

    @Column(name = "owner_occupancy_name")
    private String ownerOccupancyName;

    @Column(name = "owner_occupancy")
    private String ownerOccupancy;

    @Column(name = "loan_amount_000s")
    private String loanAmount000s;

    @Column(name = "preapproval_name")
    private String preapprovalName;

    @Column(name = "preapproval")
    private String preapproval;

    @Column(name = "action_taken_name")
    private String actionTakenName;

    @Column(name = "action_taken")
    private String actionTaken;

    @Column(name = "msamd_name")
    private String msamdName;

    @Column(name = "msamd")
    private String msamd;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_abbr")
    private String stateAbbr;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "county_name")
    private String countyName;

    @Column(name = "county_code")
    private String countyCode;

    @Column(name = "census_tract_number")
    private String censusTractNumber;

    @Column(name = "applicant_ethnicity_name")
    private String applicantEthnicityName;

    @Column(name = "applicant_ethnicity")
    private String applicantEthnicity;

    @Column(name = "co_applicant_ethnicity_name")
    private String coApplicantEthnicityName;

    @Column(name = "co_applicant_ethnicity")
    private String coApplicantEthnicity;

    @Column(name = "applicant_race_name_1")
    private String applicantRaceName1;

    @Column(name = "applicant_race_1")
    private String applicantRace1;

    @Column(name = "applicant_race_name_2")
    private String applicantRaceName2;

    @Column(name = "applicant_race_2")
    private String applicantRace2;

    @Column(name = "applicant_race_name_3")
    private String applicantRaceName3;

    @Column(name = "applicant_race_3")
    private String applicantRace3;

    @Column(name = "applicant_race_name_4")
    private String applicantRaceName4;

    @Column(name = "applicant_race_4")
    private String applicantRace4;

    @Column(name = "applicant_race_name_5")
    private String applicantRaceName5;

    @Column(name = "applicant_race_5")
    private String applicantRace5;

    @Column(name = "co_applicant_race_name_1")
    private String coApplicantRaceName1;

    @Column(name = "co_applicant_race_1")
    private String coApplicantRace1;

    @Column(name = "co_applicant_race_name_2")
    private String coApplicantRaceName2;

    @Column(name = "co_applicant_race_2")
    private String coApplicantRace2;

    @Column(name = "co_applicant_race_name_3")
    private String coApplicantRaceName3;

    @Column(name = "co_applicant_race_3")
    private String coApplicantRace3;

    @Column(name = "co_applicant_race_name_4")
    private String coApplicantRaceName4;

    @Column(name = "co_applicant_race_4")
    private String coApplicantRace4;

    @Column(name = "co_applicant_race_name_5")
    private String coApplicantRaceName5;

    @Column(name = "co_applicant_race_5")
    private String coApplicantRace5;

    @Column(name = "applicant_sex_name")
    private String applicantSexName;

    @Column(name = "applicant_sex")
    private String applicantSex;

    @Column(name = "co_applicant_sex_name")
    private String coApplicantSexName;

    @Column(name = "co_applicant_sex")
    private String coApplicantSex;

    @Column(name = "applicant_income_000s")
    private String applicantIncome000s;

    @Column(name = "purchaser_type_name")
    private String purchaserTypeName;

    @Column(name = "purchaser_type")
    private String purchaserType;

    @Column(name = "denial_reason_name_1")
    private String denialReasonName1;

    @Column(name = "denial_reason_1")
    private String denialReason1;

    @Column(name = "denial_reason_name_2")
    private String denialReasonName2;

    @Column(name = "denial_reason_2")
    private String denialReason2;

    @Column(name = "denial_reason_name_3")
    private String denialReasonName3;

    @Column(name = "denial_reason_3")
    private String denialReason3;

    @Column(name = "rate_spread")
    private String rateSpread;

    @Column(name = "hoepa_status_name")
    private String hoepaStatusName;

    @Column(name = "hoepa_status")
    private String hoepaStatus;

    @Column(name = "lien_status_name")
    private String lienStatusName;

    @Column(name = "lien_status")
    private String lienStatus;

    @Column(name = "edit_status_name")
    private String editStatusName;

    @Column(name = "edit_status")
    private String editStatus;

    @Column(name = "population")
    private String population;

    @Column(name = "minority_population")
    private String minorityPopulation;

    @Column(name = "hud_median_family_income")
    private String hudMedianFamilyIncome;

    @Column(name = "tract_to_msamd_income")
    private String tractToMsamdIncome;

    @Column(name = "number_of_owner_occupied_units")
    private String numberOfOwnerOccupiedUnits;

    @Column(name = "number_of_1_to_4_family_units")
    private String numberOf1To4FamilyUnits;

    @Column(name = "application_date_indicator")
    private String applicationDateIndicator;

    // Getters and Setters (can be generated by your IDE)
    public String getRateSpread() {
        return rateSpread;
    }
    
    public void setRateSpread(String rateSpread) {
        this.rateSpread = rateSpread;
    }
    
    public String getLoanAmount000s() {
        return loanAmount000s;
    }
    
    public void setLoanAmount000s(String loanAmount000s) {
        this.loanAmount000s = loanAmount000s;
    }
    
    public String getLienStatus() {
        return lienStatus;
    }
    
    public void setLienStatus(String lienStatus) {
        this.lienStatus = lienStatus;
    }
    
}
