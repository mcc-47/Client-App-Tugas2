/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import lombok.Data;

/**
 *
 * @author Fadel
 */
@Data
public class Contact {

    private Integer contactId;
    private String phone;
    private String linkedin;
    private Employee employee;

    public Contact(Contact contact) {
        this.contactId = contact.getContactId();
        this.phone = contact.getPhone();
        this.linkedin = contact.getLinkedin();
        this.employee = contact.getEmployee();
    }

    public Contact() {
    }

}
