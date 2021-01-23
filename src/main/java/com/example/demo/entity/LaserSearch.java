package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LASER_SEARCH")
public class LaserSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "LOOKUP_ID")
    private long lookUpId;
    @Column(name = "SERVICE_ID")
    private String serviceId;

    @OneToMany(mappedBy = "laserSearch", cascade = CascadeType.ALL)
    private Set<ServiceAudit> serviceAudits;

    public Set<ServiceAudit> getServiceAudits() {
        return serviceAudits;
    }

    public void setServiceAudits(Set<ServiceAudit> serviceAudits) {
        this.serviceAudits = serviceAudits;
    }

    public LaserSearch(){}
    public LaserSearch(String serviceId){
        this.serviceId = serviceId;
    }
    public long getLookUpId() {
        return lookUpId;
    }

    public void setLookUpId(long lookUpId) {
        this.lookUpId = lookUpId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
