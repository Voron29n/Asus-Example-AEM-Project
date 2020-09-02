import Vue from "vue";

Vue.component("vue_customized-text-data", () =>
    import ( /* webpackChunkName: "CustomizedText" */ "@components/customized-text/CustomizedText")
);