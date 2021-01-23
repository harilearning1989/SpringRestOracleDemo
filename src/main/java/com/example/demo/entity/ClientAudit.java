package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT_AUDIT")
public class ClientAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "CLIENT_AUDIT_ID")
    private long clientAuditId;
    @Column(name = "CLIENT_AUDIT_NAME")
    private String clientAuditName;

    @ManyToOne
    @JoinColumn(name = "SERVICE_AUDIT_ID")
    private ServiceAudit serviceAudit;

    public ClientAudit(){}
    public ClientAudit(String clientAuditName, ServiceAudit serviceAudit) {
        this.clientAuditName = clientAuditName;
        this.serviceAudit = serviceAudit;
    }

    public long getClientAuditId() {
        return clientAuditId;
    }

    public void setClientAuditId(long clientAuditId) {
        this.clientAuditId = clientAuditId;
    }

    public String getClientAuditName() {
        return clientAuditName;
    }

    public void setClientAuditName(String clientAuditName) {
        this.clientAuditName = clientAuditName;
    }

    public ServiceAudit getServiceAudit() {
        return serviceAudit;
    }

    public void setServiceAudit(ServiceAudit serviceAudit) {
        this.serviceAudit = serviceAudit;
    }
}
