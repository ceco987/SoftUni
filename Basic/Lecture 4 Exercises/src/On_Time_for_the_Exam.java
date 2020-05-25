import java.util.Scanner;

public class On_Time_for_the_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrHour = Integer.parseInt(scanner.nextLine());
        int arrMin = Integer.parseInt(scanner.nextLine());
        String time = "";
        int razl = 0;
        int razlch = 0;
        if (examHour == arrHour) {
            razl = examMin - arrMin;
            if (razl == 0) {
                time = "On time";
                System.out.println(time);
            } else if (razl <= 30 && razl > 0) {
                time = "On time";
                System.out.printf("%s\n%d minutes before the start", time, razl);
            } else if (razl < 0) {
                time = "Late";
                razl = arrMin - examMin;
                System.out.printf("%s\n%d minutes after the start", time, razl);
            } else {
                time = "Early";
                System.out.printf("%s\n%d minutes before the start", time, razl);
            }
        } else if (examHour == 0) {
            examHour = 24;
            if (examHour > arrHour) {
                razlch = examHour - arrHour;
                if (examHour - arrHour > 1) {
                    time = "Early";
                    if (examMin >= arrMin)
                        razl = examMin - arrMin;
                    else razl = 60 + (examMin - arrMin);
                    if (razl >= 10) {
                        System.out.printf("%s\n%d:%d hours before the start", time, razlch, razl);
                    } else if (razl > 0) {
                        System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                    } else if (razl == 0) {
                        System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                    }
                } else {
                    if (examMin >= arrMin) {
                        time = "Early";
                        razl = examMin - arrMin;
                        if (razl == 0) {
                            System.out.printf("%s\n%d:00 hours before the start", time, razlch);
                        } else if (razl > 0 && razl < 10) {
                            System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                        } else if (razl >= 10) {
                            System.out.printf("%s\n%d:%d hours before the start", time, razlch, razl);
                        }
                    } else {
                        razl = 60 + (examMin - arrMin);
                        if (razl <= 30) {
                            time = "On time";
                            if (razl >= 10) {
                                System.out.printf("%s\n%d minutes before the start", time, razl);
                            } else {
                                System.out.printf("%s\n%d minutes before the start", time, razl);
                            }
                        } else {
                            time = "Early";
                            System.out.printf("%s\n%d minutes before the start", time, razl);
                        }
                    }
                }
            } else {
                time = "Late";
                razlch = arrHour - examHour;
                if (razlch > 1) {
                    if (examMin >= arrMin)
                        razl = examMin - arrMin;
                    else {
                        razl = 60 + (examMin - arrMin);
                        razlch = razlch - 1;
                    }
                    if (razl >= 10) {
                        System.out.printf("%s\n%d:%d hours after the start", time, razlch, razl);
                    } else if (razl > 0) {
                        System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                    } else if (razl == 0) {
                        System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                    }
                } else {
                    if (arrMin >= examMin) {
                        razl = arrMin - examMin;
                        if (razl >= 10) {
                            System.out.printf("%s\n%d:%d hours after the start", time, razlch, razl);
                        } else if (razl > 0) {
                            System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                        } else {
                            System.out.printf("%s\n%d:00 hours after the start", time, razlch);
                        }
                    } else {
                        razl = 60 + arrMin - examMin;
                        System.out.printf("%s\n%d minutes after the start", time, razl);
                    }
                }
            }
        } else if (examHour > arrHour) {
            razlch = examHour - arrHour;
            if (examHour - arrHour > 1) {
                time = "Early";
                if (examMin >= arrMin)
                    razl = examMin - arrMin;
                else razl = 60 + (examMin - arrMin);
                if (razl >= 10) {
                    System.out.printf("%s\n%d:%d hours before the start", time, razlch, razl);
                } else if (razl > 0) {
                    System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                } else if (razl == 0) {
                    System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                }
            } else {
                if (examMin >= arrMin) {
                    time = "Early";
                    razl = examMin - arrMin;
                    if (razl == 0) {
                        System.out.printf("%s\n%d:00 hours before the start", time, razlch);
                    } else if (razl > 0 && razl < 10) {
                        System.out.printf("%s\n%d:0%d hours before the start", time, razlch, razl);
                    } else if (razl >= 10) {
                        System.out.printf("%s\n%d:%d hours before the start", time, razlch, razl);
                    }
                } else {
                    razl = 60 + (examMin - arrMin);
                    if (razl <= 30) {
                        time = "On time";
                        if (razl >= 10) {
                            System.out.printf("%s\n%d minutes before the start", time, razl);
                        } else {
                            System.out.printf("%s\n%d minutes before the start", time, razl);
                        }
                    } else {
                        time = "Early";
                        System.out.printf("%s\n%d minutes before the start", time, razl);
                    }
                }
            }
        } else {
            time = "Late";
            razlch = arrHour - examHour;
            if (razlch > 1) {
                if (examMin >= arrMin)
                    razl = examMin - arrMin;
                else {
                    razl = 60 + (examMin - arrMin);
                    razlch = razlch - 1;
                }
                if (razl >= 10) {
                    System.out.printf("%s\n%d:%d hours after the start", time, razlch, razl);
                } else if (razl > 0) {
                    System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                } else if (razl == 0) {
                    System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                }
            } else {
                if (arrMin >= examMin) {
                    razl = arrMin - examMin;
                    if (razl >= 10) {
                        System.out.printf("%s\n%d:%d hours after the start", time, razlch, razl);
                    } else if (razl > 0) {
                        System.out.printf("%s\n%d:0%d hours after the start", time, razlch, razl);
                    } else {
                        System.out.printf("%s\n%d:00 hours after the start", time, razlch);
                    }
                } else {
                    razl = 60 + arrMin - examMin;
                    System.out.printf("%s\n%d minutes after the start", time, razl);
                }
            }
        }
    }
}