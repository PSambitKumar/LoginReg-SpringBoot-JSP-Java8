package com.sambit.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "STATE")
public class State {
    @Column(name = "STATECODE", nullable = false, length = 2)
    private String statecode;

    @Column(name = "STATENAME", length = 50)
    private String statename;

    @Id
    @Column(name = "STATE_ID", nullable = false)
    private Long stateId;

}