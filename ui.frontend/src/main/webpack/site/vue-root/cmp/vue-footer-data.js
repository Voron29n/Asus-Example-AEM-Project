import Vue from "vue";

Vue.component('vue-footer-data', require('@components/structure/footer/Footer'));
// Vue.component('vue-footer-data', (resolve) => {
//     import ('@components/structure/footer/Footer.vue')
//     .then((Footer) => {
//         resolve(Footer.default);
//     });
// });
Vue.component(
    'vue-footer-data',
    // Динамический импорт возвращает Promise
    () =>
    // import ('@components/structure/footer/Footer')
    import ( /* webpackChunkName: "Footer" */ '@components/structure/footer/Footer')
)