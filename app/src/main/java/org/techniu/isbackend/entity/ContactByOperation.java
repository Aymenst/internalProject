package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "ContactByOperation")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain=true)
@Builder
public class ContactByOperation {
    @Id
    private String _id;
    private String description;
    @DBRef
    private CommercialOperationStatus status;
    //contract Type
    private String contactsType;
    //liste of mondatory attributes
    private List<String> mandatoryAttributes;
}
