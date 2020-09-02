import Vue from "vue";

Vue.component("vue_footer-data", () =>
    import ( /* webpackChunkName: "Footer" */ "@components/structure/footer/Footer")
);