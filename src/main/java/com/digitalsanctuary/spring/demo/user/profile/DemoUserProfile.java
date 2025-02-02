package com.digitalsanctuary.spring.demo.user.profile;

import java.util.ArrayList;
import java.util.List;
import com.digitalsanctuary.spring.user.profile.BaseUserProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "demo_user_profile")
@EqualsAndHashCode(callSuper = true)
public class DemoUserProfile extends BaseUserProfile {

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventRegistration> eventRegistrations = new ArrayList<>();

    private String favoriteColor;
    private boolean receiveNewsletter;

    public void addEventRegistration(EventRegistration registration) {
        eventRegistrations.add(registration);
        registration.setUserProfile(this);
    }

    public void removeEventRegistration(EventRegistration registration) {
        eventRegistrations.remove(registration);
        registration.setUserProfile(null);
    }
}
