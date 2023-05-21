package com.example.ownroadrider;

public class CardForDetailSchedule {
        private String destTitle;
        private Integer destImg;
        private Integer rating;
        private String review;

        public CardForDetailSchedule(String destTitle, Integer rating, String review, Integer destImg) {
            this.destTitle = destTitle;
            this.destImg = destImg;
            this.rating = rating;
            this.review = review;
        }

        public String getDestTitle() {
            return destTitle;
        }
        public void setDestTitle(String destTitle) {
            this.destTitle = destTitle;
        }

        public Integer getDestImg() {
            return destImg;
        }
        public void setDestImg(Integer destImg) {
            this.destImg = destImg;
        }

        public Integer getRating() {
            return rating;
        }
        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getReview() {
            return review;
        }
        public void setReview(String review) {
            this.review = review;
        }
}
