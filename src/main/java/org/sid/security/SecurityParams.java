/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.security;

/**
 *
 * @author abbasturki.elias
 */

class SecurityParams {

    public static final long  EXPIRATION_TIME=864_000_000;//10 days
    public static final String  PRIVATE_SECRET="elias";
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String JWT_HEADER ="Authorization";
    
}
