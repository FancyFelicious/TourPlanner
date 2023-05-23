package org.fancylynx.application.model.tour;

//@Data
//@Repository
public class TourManager implements Tour {
    //    private String name;
//    private String description;
//    private String from;
//    private String to;
//    private String transportType;
//    private Double tourDistance;
//    private String estimatedTime;
//    private String routeInformation;
//
    public TourManager() {
    }

    @Override
    public String createNewTour() {
        return null;
    }

    // get request
    // parse
    // create tour object
    // set values set by user (to, from etc.) on object
    // make api request
    // if successful: call repository to save object to db
    // return response to controller
    // controller updates ui based on response
}
