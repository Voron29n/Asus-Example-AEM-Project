<template>
    <div :class="[this.blackVersion ? 'black-version' : 'white-version']">
        <div class="aai-inner">
            <div class="aai-fmiddle">
                <VueLinksGroup :links-group-data="linksGroupData" :socials-data="socialsData"></VueLinksGroup>
            </div>
            <div class="aai-fbootom">
                <VueLanguage :language-data="languageData"></VueLanguage>
                <VueCopyright :copyrights-data="copyrightsData"></VueCopyright>
            </div>
        </div>
    </div>
</template>

<script>
import Vue from "vue";
Vue.component('VueLinksGroup', require("@components/structure/footer/v-components/linksGroup/LinksGroup"));
export default {
    name: "footer-data",
    components: {
        "footer-data": () => import( /* webpackChunkName: "Footer" */ './Footer.vue').then(m => m.default),
        VueCopyright: () =>
            import(
                /* webpackChunkName: "Footer" */ "./v-components/copyrights/Copyrights"
            ),
        VueLanguage: () =>
            import(
                /* webpackChunkName: "Footer" */ "./v-components/language/Language"
            ),
        VueLinksGroup: () =>
            import(
                /* webpackChunkName: "Footer" */ "./v-components/linksGroup/LinksGroup"
            ),
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
            document.querySelector("body footer").style.background = this
                .blackVersion
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
