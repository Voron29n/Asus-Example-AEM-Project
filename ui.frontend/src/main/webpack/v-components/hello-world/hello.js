import Vue from "vue";

import Hello from "./Hello.vue";

Vue.config.devtools = true;

new Vue({
    el: ".hello-component",
    render: a => a(Hello)
});