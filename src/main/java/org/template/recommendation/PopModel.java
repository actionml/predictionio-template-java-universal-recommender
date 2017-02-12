package org.template.recommendation;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.json4s.JsonAST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.apache.predictionio.data.storage.Event;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PopModel {
    private static class RankingFieldName {
        public static final String UserRank = "userRank";
        public static final String UniqueRank = "uniqueRank";
        public static final String PopRank = "popRank";
        public static final String TrendRank = "trendRank";
        public static final String HotRank = "hotRank";
        public static final String UnknownRank = "unknownRank";

        public List<String> toList() {
            List<String> list = new LinkedList<>();
            list.addAll(Arrays.asList(new String[]{UserRank, UniqueRank, PopRank, TrendRank, UnknownRank}));
            return list;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s, %s, %s, %s", UserRank, UniqueRank, PopRank, TrendRank, HotRank);
        }
    }

    private static class RankingType {
        public static final String Popular = "popular";
        public static final String Trending = "trending";
        public static final String Hot = "hot";
        public static final String UserDefined = "userDefined";
        public static final String Random = "random";

        public List<String> toList() {
            List<String> list = new LinkedList<>();
            list.addAll(Arrays.asList(new String[]{Popular, Trending, Hot, UserDefined, Random}));
            return list;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s, %s, %s, %s", Popular, Trending, Hot, UserDefined, Random);
        }
    }

    private transient static final Logger logger = LoggerFactory.getLogger(PopModel.class);
    private final JavaPairRDD<String, Map<String, JsonAST.JValue>> fieldsRDD;  // ItemID -> ItemProps
    private final JavaSparkContext sc;

    /**
     *
     * @param fieldsRDD
     * @param sc
     */
    public PopModel(JavaPairRDD<String, Map<String, JsonAST.JValue>> fieldsRDD, JavaSparkContext sc) {
        this.fieldsRDD = fieldsRDD;
        this.sc = sc;
    }

    /**
     * Create random rank for all items
     * @param modelName
     * @param eventNames
     * @param appName
     * @param duration
     * @param offsetDate
     * @return RDD<ItemID, Double>
     */
    public JavaPairRDD<String, Double> calc(String modelName, List<String> eventNames, String appName, Integer duration, String offsetDate) {
        //TODO: implement
        return null;
    }

    /**
     * Create random rank for all items
     * @param appName
     * @param interval
     * @return RDD<ItemID, Double>
     */
    public JavaPairRDD<String, Double> calcRandom(String appName, Interval interval) {
        //TODO: implement
        return null;
    }

    /**
     * Creates rank from the number of named events per item for the duration
     * @param appName
     * @param eventNames
     * @param interval
     * @return RDD<ItemID, Double>
     */
    public JavaPairRDD<String, Double> calcPopular(String appName, List<String> eventNames, Interval interval) {
        //TODO: implement
        return null;
    }

    /**
     * Creates a rank for each item by dividing the duration in two and counting named events in both buckets
     * then dividing most recent by less recent. This ranks by change in popularity or velocity of populatiy change.
     * Interval(start, end) end instant is always greater than or equal to the start instant.
     * @param appName
     * @param eventNames
     * @param interval
     * @return RDD<ItemID, Double>
     */
    public JavaPairRDD<String, Double> calcTrending(String appName, List<String> eventNames, Interval interval) {
        //TODO: implement
        return null;
    }

    /**
     * Creates a rank for each item by divding all events per item into three buckets and calculating the change in
     * velocity over time, in other words the acceleration of popularity change.
     * @param appName
     * @param eventNames
     * @param interval
     * @return RDD<ItemID, Double>
     */
    public JavaPairRDD<String, Double> calcHot(String appName, List<String> eventNames, Interval interval) {
        //TODO: implement
        return null;
    }

    /**
     *
     * @param appName
     * @param eventNames
     * @param interval
     * @return
     */
    public JavaRDD<Event> eventsRDD(String appName, List<String> eventNames, Interval interval) {
        //TODO: implement
        return null;
    }
}
