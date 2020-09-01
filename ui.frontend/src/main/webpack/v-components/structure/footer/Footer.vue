<template>
  <div :class="[this.blackVersion ? 'black-version' : 'white-version']">
    <div class="aai-inner">
      <div class="aai-fmiddle">
        <v-linksGroup
          :links-group-data="linksGroupData"
          :socials-data="socialsData"
        ></v-linksGroup>
      </div>
      <div class="aai-fbootom">
        <VueLanguage :language-data="languageData"></VueLanguage>
        <VueCopyright :copyrights-data="copyrightsData"></VueCopyright>
      </div>
    </div>
  </div>
</template>

<script>
// import Footer_LanguageCmp from "./v-components/language/Language";
// import Footer_CopyrightsCmp from "./v-components/copyrights/Copyrights";
// import Footer_LinksGroupCmp from "./v-components/linksGroup/LinksGroup";

export default {
  // name: "footer-component-vue",
    name: "Footer",
  beforeCreate: function() {
    // (this.$options.components.Footer_LanguageCmp = require("./Footer.vue").default),
    // (this.$options.components.Footer_LinksGroupCmp = require("./Footer.vue").default),
    // (this.$options.components.Footer_CopyrightsCmp = require("./Footer.vue").default);
    
    // (this.$options.components.VueFooterData = require("./Footer.vue").default);
    // this.$options.components.vueFooterData = require("./Footer.vue");
    // Vue.component('vue-footer-data', require('@components/structure/footer/Footer.vue'), {
    //     name: 'vue-footer-data'
    // });
    // Vue.component('vue-footer-data', require('./Footer.vue'));
    // Vue.component('vue-footer-data', require('@components/structure/footer/Footer'));
  },
  components: {
    // vLanguage:  () => import(/* webpackChunkName: "vLanguage" */'./v-components/language/Language.vue'),
    // vLinksGroup: () => import(/* webpackChunkName: "vLinksGroup" */'./v-components/linksGroup/LinksGroup.vue'),
    // vCopyrights: () => import(/* webpackChunkName: "vCopyrights" */'./v-components/copyrights/Copyrights.vue'),
    // "v-language":  () => import("./v-components/language/Language"),
    // "v-linksGroup": () => import("./v-components/linksGroup/LinksGroup"),
    // "v-copyrights": () => import("./v-components/copyrights/Copyrights"),
    // vLanguage:  () => import(/* webpackChunkName: "" */ './v-components/language/Language'),
    // vLinksGroup:  () => import(/* webpackChunkName: "" */ './v-components/linksGroup/LinksGroup'),
    // vCopyrights:  () => import(/* webpackChunkName: "" */ './v-components/copyrights/Copyrights'),
    // vueFooterData: () => import(/* webpackChunkName: "" */ './Footer'),

    VueCopyright:  () => import(/* webpackChunkName: "Footer" */ './v-components/copyrights/Copyrights'),
    VueLanguage:  () => import(/* webpackChunkName: "Footer" */ './v-components/language/Language'),
    // "v-language": Footer_LanguageCmp,
    // "v-copyrights": Footer_CopyrightsCmp,
    "v-linksGroup": () => import(/* webpackChunkName: "Footer" */ './v-components/linksGroup/LinksGroup'),

    
    
  },
  props: {
    blackVersion: {
      type: Boolean,
      required: false,
    },
    descriptionLink: {
      type: String,
      required: false,
    },
    linkTo: {
      type: String,
      required: false,
    },
    linkUrlTarget: {
      type: String,
      required: false,
    },
    fileReference: {
      type: String,
      required: false,
    },
    linksGroup: {
      type: String,
      required: false,
    },
    socials: {
      type: String,
      required: false,
    },
    socialsTitle: {
      type: String,
      required: false,
    },
    copyrights: {
      type: String,
      required: false,
    },
  },
  mounted() {
    this.applyCurrentFooterStyle();
  },
  methods: {
    applyCurrentFooterStyle() {
      document.querySelector("body footer").style.background = this.blackVersion
        ? "#242424"
        : "#ECECEC";
    },
  },
  computed: {
    languageData() {
      return {
        descriptionLink: this.$props.descriptionLink,
        linkTo: this.$props.linkTo,
        linkUrlTarget: this.$props.linkUrlTarget,
        fileReference: this.$props.fileReference,
      };
    },
    linksGroupData() {
      return {
        linksGroup: JSON.parse(this.$props.linksGroup),
      };
    },
    socialsData() {
      return {
        socialsTitle: this.$props.socialsTitle,
        socials: JSON.parse(this.$props.socials),
      };
    },
    copyrightsData() {
      return {
        copyrights: JSON.parse(this.$props.copyrights),
      };
    },
  },
};


</script>

<style lang="scss">
@import "./v-style/footer_default";
@import "./v-style/footer_media";
</style>
