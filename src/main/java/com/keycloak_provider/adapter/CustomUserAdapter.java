package com.keycloak_provider.adapter;

import com.keycloak_provider.dto.UserInfo;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

public class CustomUserAdapter extends AbstractUserAdapterFederatedStorage {

    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Long dbId;

    public CustomUserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, UserInfo userInfo) {
        super(session, realm, model);
        this.username = userInfo.getUsername();
        this.email = userInfo.getEmail();
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.dbId = userInfo.getId();
    }

    @Override
    public String getId() {
        return String.valueOf(this.dbId);
    }

    @Override
    public String getUsername() { return this.username; }

    @Override
    public void setUsername(String username) {
        throw new UnsupportedOperationException("Username cannot be changed");
    }

    @Override
    public void grantRole(RoleModel role) { super.grantRole(role); }

    @Override
    public void deleteRoleMapping(RoleModel role) { super.deleteRoleMapping(role); }

    @Override
    public String getEmail() { return this.email; }

    @Override
    public String getFirstName() { return this.firstName; }

    @Override
    public String getLastName() { return this.lastName; }
}
