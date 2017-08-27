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
class forLot {
    private String owner_name,reg_no,car_type,time,date;
    private Integer slot_no;
    
    public forLot(String owner_name,String reg_no,String car_type,Integer slot_no,String time,String date){
        this.owner_name=owner_name;
        this.reg_no=reg_no;
        this.car_type=car_type;
        this.slot_no=slot_no;
        this.time=time;
        this.date=date;
    }
    public String owner_name(){
        return owner_name;
    }
    public String reg_no(){
        return reg_no;
    }
    public String car_type(){
        return car_type;
    }
    public Integer slot_no(){
        return slot_no;
    }
    public String time(){
        return time;
    }
    public String date(){
        return date;
    }
}
