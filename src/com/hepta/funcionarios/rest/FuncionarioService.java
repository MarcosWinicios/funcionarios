package com.hepta.funcionarios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.persistence.FuncionarioDAO;


@Path("/funcionarios")
public class FuncionarioService {

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    private FuncionarioDAO dao;

    public FuncionarioService() {
        dao = new FuncionarioDAO();
    }

    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Adiciona novo Funcionario
     * 
     * @param Funcionario: Novo Funcionario
     * @return response 200 (OK) - Conseguiu adicionar
     * @throws Exception 
     */
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response funcionarioCreate(Funcionario funcionario) throws Exception {
    	this.dao.save(funcionario);
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    /**
     * Lista todos os Funcionarios
     * 
     * @return response 200 (OK) - Conseguiu listar
     */
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response funcionarioRead() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            funcionarios = dao.getAll();

        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Funcionarios").build();
        }

        GenericEntity<List<Funcionario>> entity = new GenericEntity<List<Funcionario>>(funcionarios) {
        };
        return Response.status(Status.OK).entity(entity).build();
    }

    /**
     * Atualiza um Funcionario
     * 
     * @param id:          id do Funcionario
     * @param Funcionario: Funcionario atualizado
     * @return response 200 (OK) - Conseguiu atualizar
     * @throws Exception 
     */
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Response funcionarioUpdate(@PathParam("id") Integer id, Funcionario funcionario) throws Exception {
    	funcionario.setId(id);
    	dao.update(funcionario);
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    /**
     * Remove um Funcionario
     * 
     * @param id: id do Funcionario
     * @return response 200 (OK) - Conseguiu remover
     * @throws Exception 
     */
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response funcionarioDelete(@PathParam("id") Integer id) throws Exception {
    	dao.delete(id);
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    /**
     * Métodos simples apenas para testar o REST
     * @return
     */
    @Path("/teste")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String testeJersey() {
        return "Funcionando.";
    }

}
