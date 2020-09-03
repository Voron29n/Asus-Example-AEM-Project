import Vue from "vue";
let tagNameVue = "grid-parsys_desk3-mobile4-or-mobile2-data";

Vue.component(tagNameVue, require("@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "" */ "@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys")
);