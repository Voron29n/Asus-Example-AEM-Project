import Vue from "vue";

import HeroBannerMiddle from "./HeroBannerMiddle";

const componentSelector = "#hero-banner-middle-vue";

const element = document.querySelector(componentSelector);

var vueGlobalObject = !element
    ? console.log("Can't find element with same selector:" + componentSelector)
    : new Vue({
          el: componentSelector,
          components: { "hero-banner-middle": HeroBannerMiddle },
          template: componentSelector,
      });
