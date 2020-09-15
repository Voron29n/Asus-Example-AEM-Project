<template>
    <div
        class="slick-arrow-font-awesome"
        :class="[isNextArrow ? 'next' : 'prev']"
        @click="slickNext"
    >
        <i :class="[isNextArrow ? iconClassData.nextClass : iconClassData.prevClass]"></i>
    </div>
</template>

<script>
export default {
    props: {
        isNextArrow: {
            type: Boolean,
            required: false,
            default: false,
        },
    },
    data() {
        return {
            iconClassData: {
                nextClass: "fas fa-chevron-right",
                prevClass: "fas fa-chevron-left",
            },
        };
    },
    methods: {
        slickNext() {
            this.$emit("change-slick-arrow-font-awesome", this.isNextArrow);
        },
    },
};
import(
    /* webpackChunkName: "SlickArrowFontAwesome" */ "./_slick-arrow-font-awesome_default.scss"
);
</script>


