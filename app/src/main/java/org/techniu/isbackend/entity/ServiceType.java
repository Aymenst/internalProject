package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Commercial_ServiceType")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    private String serviceTypeId;
    private String name;
    private String description;
}
