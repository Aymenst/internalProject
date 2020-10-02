package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "SectorConfig")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorConfig implements Serializable {
    @Id
    private String sectorConfigId;
    @DBRef
    private Sector primarySector;
    @DBRef
    private Sector secondarySector;
    @DBRef
    private Sector thirdSector;
    @DBRef
    private Staff staff;
}
