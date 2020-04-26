package com.dib.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dib.command.PatientCommand;

@Component("patCmdValidator")
public class PatientCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("PatientCommandValidator.supports()");
		return clazz.isAssignableFrom(PatientCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("PatientCommandValidator.validate()");
		PatientCommand patCmd=null;

		patCmd=(PatientCommand)target;

		if(patCmd.getVflag().equalsIgnoreCase("no")) {

			if(patCmd.getPatName()==null || patCmd.getPatName().equalsIgnoreCase("") || patCmd.getPatName().length()==0)
			{
				errors.rejectValue("patName", "name.required");
			}
			if(patCmd.getAge()==0)
			{
				errors.rejectValue("age", "age.required");
			}
			else if(patCmd.getAge()<1 || patCmd.getAge()>100)
			{
				errors.rejectValue("age", "age.range");
			}
			if(patCmd.getLocation()==null || patCmd.getLocation().equalsIgnoreCase("") || patCmd.getLocation().length()==0)
			{
				errors.rejectValue("location", "location.required");
			}
			if(patCmd.getHospital()==null || patCmd.getHospital().equalsIgnoreCase("") || patCmd.getHospital().length()==0)
			{
				errors.rejectValue("hospital", "hospital.required");
			}

		}

	}

}
