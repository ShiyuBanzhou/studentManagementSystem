public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(String birthday){
        String[] strArr = birthday.split("\\.");
        this.year = Integer.parseInt(strArr[0]);
        this.month = Integer.parseInt(strArr[1]);
        this.day = Integer.parseInt(strArr[2]);
    }

    /**
     * 获取
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * 设置
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * 获取
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * 设置
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    public boolean birthdayCorrectnessCheck(){
        if(0 <= this.year && this.year <= 2023){
            if(1 <= this.month && this.month <= 12){
                if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month ==8
                ||this.month == 10 || this.month == 12){
                    if(1 <= this.day && this.day <= 31){
                        return true;
                    }
                }else{
                    if(this.month == 2){
                        if(((this.year % 4 == 0) && (this.year % 100 !=0)) || (this.year % 400 == 0)){
                            if(1 <= this.day && this.day <= 29){
                                return true;
                            }
                        }else{
                            if(1 <= this.day && this.day <= 28){
                                return true;
                            }
                        }
                    }else{
                        if(1 <= this.day && this.day <= 30){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean examdayCorrectnessCheck(){
        if(0 <= this.year){
            if(1 <= this.month && this.month <= 12){
                if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month ==8
                        ||this.month == 10 || this.month == 12){
                    if(1 <= this.day && this.day <= 31){
                        return true;
                    }
                }else{
                    if(this.month == 2){
                        if(((this.year % 4 == 0) && (this.year % 100 !=0)) || (this.year % 400 == 0)){
                            if(1 <= this.day && this.day <= 29){
                                return true;
                            }
                        }else{
                            if(1 <= this.day && this.day <= 28){
                                return true;
                            }
                        }
                    }else{
                        if(1 <= this.day && this.day <= 30){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return year + "." + month + "." + day;
    }
}
