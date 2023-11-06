package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.entitys.*;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

    //Account
    public static Account convertFromAccountVmToAccount(AccountVm accountVm){
        return new Account(accountVm.getEmail(),accountVm.getReceivedMessages(),accountVm.getSentMessages(),accountVm.getName(),accountVm.getAge());
    }
    public static AccountVm convertFromAccountToAccountVm(Account account){
        return new AccountVm(account.getId(),account.getEmail(),account.getReceivedMessages(),account.getSentMessages(), account.getName(), account.getAge());
    }
    //Patient
    public static PatientVm convertFromPatientToPatientVM(Patient patient){
        PatientVm patientVm = new PatientVm(patient.getId(), patient.getmCondition(),ConverterUtil.convertFromAccountToAccountVm(patient.getAccount()));
        return patientVm;
    }
    public static Patient convertFromPatientVmToPatient(PatientVm patientVm){
        Patient patient = new Patient(patientVm.getmCondition(),ConverterUtil.convertFromAccountVmToAccount(patientVm.getAccountVm()));
        return patient;
    }
    public static List<PatientVm> convertFromPatientListToPatientVMList(List<Patient> list){
        List<PatientVm> patientVmList = new ArrayList<>();

        for (Patient patient : list) {
            PatientVm patientVm = new PatientVm(patient.getId(), patient.getmCondition(),ConverterUtil.convertFromAccountToAccountVm(patient.getAccount()));
            patientVmList.add(patientVm);
        }

        return patientVmList;
    }
    //Message
    public static Message convertFromMessageVmToMessage(MessageVm messageVm){
        return new Message(messageVm.getText(),messageVm.getSender(),messageVm.getReceiver());
    }
    public static MessageVm convertFromMessageToMessageVm(Message message){
        return  new MessageVm(message.getId(), message.getText(), message.getDate(),message.getSender(), message.getReceiver());
    }
    public static Doctor convertFromDoctorVmToDoctor(DoctorVm doctorVm) {
        return new Doctor(convertFromAccountVmToAccount(doctorVm.getAccountVm()));
    }
    public static Employee convertFromEmployeeVmToEmplyee(EmployeeVm employeeVm) {
        return new Employee(convertFromAccountVmToAccount(employeeVm.getAccountVm()));
    }
    //Observation
    public static Observation convertFromObservationVmToObservation(ObservationVm observationVm) {
        return new Observation(observationVm.getDescription(),observationVm.getPatient());
    }
    public static ObservationVm convertFromObservationToObservationVm(Observation observation) {
        return new ObservationVm(observation.getId(),observation.getDescription(),observation.getDate(),observation.getPatient());
    }
    public static List<ObservationVm> convertFromObservationToObservationVmList(List<Observation> observations){
        List<ObservationVm> observationVms = new ArrayList<>();
        for (Observation o:observations) {
            observationVms.add(convertFromObservationToObservationVm(o));
        }
        return observationVms;
    }
    public static List<Observation> convertFromObservationVmToObservationList(List<ObservationVm> observationVms){
        List<Observation> observations = new ArrayList<>();
        for (ObservationVm ovm : observationVms) {
            observations.add(convertFromObservationVmToObservation(ovm));
        }
        return observations;
    }
    //Encounter
    public static List<Encounter> convertFromEncounterVmToEncounterList(List<EncounterVm> encounterVms){
        List<Encounter> encounters = new ArrayList<>();
        for (EncounterVm evm : encounterVms) {
            encounters.add(convertFromEncounterVmToEncounter(evm));
        }
        return encounters;
    }
    public static Encounter convertFromEncounterVmToEncounter(EncounterVm encounterVm) {
        return new Encounter(encounterVm.getWorkerId(),encounterVm.getPatientId(),convertFromObservationVmToObservationList(encounterVm.getObservationVms()));
    }
}
