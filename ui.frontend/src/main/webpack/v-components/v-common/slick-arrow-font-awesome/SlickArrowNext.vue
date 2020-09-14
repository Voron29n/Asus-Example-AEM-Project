<template>
    <div class="slick-arrow-font-awesome next">
        <i :class="iconClass" @click="slickNext"></i>
    </div>
</template>

<script>
export default {
    data() {
        return {
            iconClass: "fas fa-chevron-left",
            isSlickNext: true,
        };
    },
    methods: {
        slickNext() {
            this.$emit("change-slick-arrow-font-awesome", this.isSlickNext);
        },
    },
};
import (/* webpackChunkName: "SlickArrowNext" */ './_slick-arrow_default.scss');
</script>


