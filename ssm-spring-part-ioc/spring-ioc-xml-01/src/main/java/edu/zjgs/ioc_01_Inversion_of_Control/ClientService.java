package edu.zjgs.ioc_01_Inversion_of_Control;

public class ClientService {
  private static ClientService clientService = new ClientService();
  private ClientService() {}

  public static ClientService createInstance() {
  
    return clientService;
  }
}