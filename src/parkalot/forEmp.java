/*
 * Copyright (C) 2017 lll2yu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package parkalot;

/**
 *
 * @author lll2yu
 */
class forEmp {
    private String fname,login,address,pass;
    
    public forEmp(String fname,String login,String address,String pass){
        this.fname=fname;
        this.login=login;
        this.address=address;
        this.pass=pass;
    }
    public String fname(){
        return fname;
    }
    public String login(){
        return login;
    }
    public String address(){
        return address;
    }
    public String pass(){
        return pass;
    }
}
