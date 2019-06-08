/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.utils;

/**
 *
 * @author alberto
 */
public class TrioCheckBox {
    private int id;
    private String nome;
    private boolean check;

    public TrioCheckBox(int id, String nome, boolean check) {
        this.id = id;
        this.nome = nome;
        this.check = check;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
}
