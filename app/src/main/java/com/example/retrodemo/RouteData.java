package com.example.retrodemo;

public class RouteData {

    String route;
    String response_code;
    String train;
    String debit;

    public RouteData(String route, String response_code, String train, String debit) {
        this.route = route;
        this.response_code = response_code;
        this.train = train;
        this.debit = debit;
    }

    public String getRoute() {
        return route;
    }

    public String getResponse_code() {
        return response_code;
    }

    public String getTrain() {
        return train;
    }

    public String getDebit() {
        return debit;
    }
}
