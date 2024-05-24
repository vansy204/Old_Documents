package java_35;

public class date {
    private int day;
    private int month;
    private int year;

    public date(int day, int month, int year) {
        if (year >= 0) {
            this.year = year;
            if (month >= 1 && month <= 12) {
                this.month = month;
                switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12:
                        if (day >= 1 && day <= 31) {
                            this.day = day;
                        } else {
                            this.day = 1;
                        }
                    case 4, 6, 9, 11:
                        if (day >= 1 && day <= 30) {
                            this.day = day;
                        } else {
                            this.day = 1;
                        }
                    case 2:
                        if (day >= 1 && day <= 28) {
                            this.day = day;
                        } else {
                            this.day = 1;
                        }
                }

            } else {
                this.day = 1;
                this.month = 1;
            }
        } else {
            this.day = 1;
            this.month = 1;
            this.year = 1;
        }
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        if(year >= 0){
            this.year = year;
        }
    }
    public void setMoth(int month){
        if(month >=1 && month <=12){
            this.month = month;
        }
    }
    public void setDay(int day){
        switch (this.month) {
            case 1, 3, 5, 7, 8, 10, 12:
                if (day >= 1 && day <= 31) {
                    this.day = day;
                } 
            case 4, 6, 9, 11:
                if (day >= 1 && day <= 30) {
                    this.day = day;
                } 
            case 2:
                if (day >= 1 && day <= 28) {
                    this.day = day;
                } 
        }
    }
}
