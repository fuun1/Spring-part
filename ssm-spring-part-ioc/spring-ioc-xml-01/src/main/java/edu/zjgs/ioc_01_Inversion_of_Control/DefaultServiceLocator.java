package edu.zjgs.ioc_01_Inversion_of_Control;

public class DefaultServiceLocator {

  private static ClientServiceImpl clientService = new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService;
  }
}