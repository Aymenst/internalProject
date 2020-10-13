package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ClientAddrequest;
import org.techniu.isbackend.dto.model.ClientDto;
import org.techniu.isbackend.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    /**
     * Map dto to model
     *
     * @param clientDto clientDto
     * @return Client
     */
    @Mapping(source = "clientId", target="_id")
    @Mapping(target = "address", ignore=true)
    @Mapping(target = "assistantCommercial", ignore=true)
    @Mapping(target = "responsibleCommercial", ignore=true)
    Client dtoToModel(ClientDto clientDto);

    /**
     * Map clientRequest to clientDo
     *
     * @param clientAddrequest clientAddrequest
     * @return ClientDto
     */
    ClientDto addRequestToDto(ClientAddrequest clientAddrequest);

    /**
     * Map client to clientDo
     *
     * @param client client
     * @return ClientDto
     */
    @Mapping(source = "_id", target="clientId")
    @Mapping(target = "assistantCommercial", ignore=true)
    @Mapping(target = "responsibleCommercial", ignore=true)
    ClientDto modelToDto(Client client);
}
