package com.aem.core.serviceimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.core.services.SightlyServiceInterface;

@Component(immediate=true,service=SightlyService.class)
public class SightlyService implements SightlyServiceInterface {

	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		return "RamaSita";
	}

	@Override
	public String getDeveloperProfile() {
		// TODO Auto-generated method stub
		return "AEM Developer";
	}

	@Override
	public String getDeveloperSkills() {
		// TODO Auto-generated method stub
		return "Java, AEM";
	}

	@Override
	public String getDeveloperData() {
		// TODO Auto-generated method stub
		String name = this.getDeveloperName();
        String profile = this.getDeveloperProfile();
        String skills = this.getDeveloperSkills();
        return name + " is a " + profile + ", He is expert in skills like " + skills;
	}

}
