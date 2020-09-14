<template>
    <div class="slick-arrow-font-awesome prev">
        <i :class="iconClass" @click="slickNext"></i>
    </div>
</template>

<script>
export default {
    data() {
        return {
            iconClass: "fas fa-chevron-right",
            isSlickNext: false,
        };
    },
    methods: {
        slickNext() {
            this.$emit("change-slick-arrow-font-awesome", this.isSlickNext);
        },
    },
};
import (/* webpackChunkName: "SlickArrowPrev" */ './_slick-arrow_default.scss');
</script>


