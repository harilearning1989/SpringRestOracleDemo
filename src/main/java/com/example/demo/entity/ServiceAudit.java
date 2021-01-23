package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SERVICE_AUDIT")
public class ServiceAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "AUDIT_ID")
    private long auditId;
    @Column(name = "AUDIT_NAME")
    private String auditName;

    @ManyToOne
    @JoinColumn(name = "LOOKUP_ID")
    private LaserSearch laserSearch;

    @OneToMany(mappedBy = "serviceAudit", cascade = CascadeType.ALL)
    private Set<ClientAudit> clientAudits;

    public ServiceAudit(){}
    public ServiceAudit(String auditName, LaserSearch laserSearch) {
        this.auditName = auditName;
        this.laserSearch = laserSearch;
    }

    public long getAuditId() {
        return auditId;
    }

    public void setAuditId(long auditId) {
        this.auditId = auditId;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public LaserSearch getLaserSearch() {
        return laserSearch;
    }

    public void setLaserSearch(LaserSearch laserSearch) {
        this.laserSearch = laserSearch;
    }

    public Set<ClientAudit> getClientAudits() {
        return clientAudits;
    }

    public void setClientAudits(Set<ClientAudit> clientAudits) {
        this.clientAudits = clientAudits;
    }
}
