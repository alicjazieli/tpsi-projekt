/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.jpa;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "username")
    private String username;
    
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    
    @Size(max = 30)
    @Column(name = "password")
    private String password;
}
