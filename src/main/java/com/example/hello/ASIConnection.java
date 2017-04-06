package com.example.hello;

import org.springframework.beans.factory.annotation.Value;

public final class ASIConnection
{
 
  
  
  /**
   * This class is a Singleton, this represents the member variable instance of the class 
   * that will be retrieved via a getMethod when a client needs to get an ASIConnection
   *//*
  private static ASIConnection connection; 
  
  *//**
   *   The GetAccess Admin User
   *//*
  @Value("${iassconfig.getaccess.gausername}")
  private String adminUsername;
  
  *//**
   * De-crypted GetAccess Admin password
   *//*
  @Value("${iassconfig.getaccess.gauserpassword}")
  private String decryptedAdminPassword;
  
  *//**
   * The GetAccess URL for ASI connections
   *//*
  @Value("${iassconfig.getaccess.gaurl}")
  private String gaUrl;
  
  
  *//**
   * ASIConnection
   * 
   * Construct the ASIConnection
   * 
   * Create a connection to the GetAccess ASI
   * 
   * This connection will be used later to get the User and UserRole api's which allow adminstration functions
   *
   *//*
  private ASIConnection()
  {
    // Create the connection
    try
    {     
      // create an Administration UserPassword Connection
      System.out.println("adminUsername ==========>   "+adminUsername);
      System.out.println("decryptedAdminPassword ==========>   "+decryptedAdminPassword);
      System.out.println("gaUrl ==========>   "+gaUrl);
      asiConnection = new UserPasswordConnection(adminUsername, decryptedAdminPassword, gaUrl);
      // And make the connection to the Administration Service Interface (ASI)
      asiConnection.connect();
    }
    catch (Exception ex)
    {
      // it wasnt happy so ensure the connection is relinquished
    	if(null != asiConnection)
    	{
        try
        {
          asiConnection.logout();
        }
        catch (Exception ex2)
        {
          // Ignored as this is probably due to the connect call above not
          // completing properly.
        }
    	}

      // and zero the singleton for the connection itself.
      asiConnection = null;

      // finally mark an incident along with the exception to record the connection failure
      throw new RuntimeException("Failed to create a connection with GetAccess", ex);
    }
  }
  
  
  
  *//**
   * getConnection
   * 
   * @return ASIConnection an instance of the internal ASIConnection class
   * 
   * This class is a singleton and so serves as a self Factory
   * 
   *//*
  public static synchronized ASIConnection getConnection()
  {
    // Is the connection null
    if(connection == null)
    {
      // Yes, so instantiate a new connection
      connection = new ASIConnection();
    }
    return connection;
  }
 */ 
}