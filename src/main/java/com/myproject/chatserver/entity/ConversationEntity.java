package com.myproject.chatserver.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "conversation")
public class ConversationEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, targetEntity = ParticipantEntity.class)
    private List<ParticipantEntity> participant;

    public ConversationEntity(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.participant = new ArrayList<>();
    }
}