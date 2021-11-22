package com.classactivity.classactivity.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Clients implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long clientId;
    @Column
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
