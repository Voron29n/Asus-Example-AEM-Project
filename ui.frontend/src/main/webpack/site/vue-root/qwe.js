import Vue from "vue";

Vue.component('vue-footer-data', require('@components/structure/footer/Footer.vue'));
Vue.component('vue-footer-data', (resolve) => {
    import ('@components/structure/footer/Footer.vue')
    .then((Footer) => {
        resolve(Footer.default);
    });
});