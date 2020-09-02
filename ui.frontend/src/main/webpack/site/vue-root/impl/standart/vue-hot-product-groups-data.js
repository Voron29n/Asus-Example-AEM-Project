import Vue from "vue";

Vue.component("vue-hot-product-groups-data", () =>
    import ( /* webpackChunkName: "HotProductGroups" */ "@components/standart/hot-product-groups/HotProductGroups")
);