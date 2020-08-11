<template>
<div id="footer-component-vue">
        <v-linksGroup :links-group-data="linksGroupData"></v-linksGroup>
        <v-socials :socials-data="socialsData"></v-socials>
        <v-language :language-data="languageData"></v-language>
        <v-copyrights :copyrights-data="copyrightsData"></v-copyrights>
</div>
</template>

<script>
import LanguageData from './v-components/language/Language'
import LinksGroupData from './v-components/linksGroup/LinksGroup'
import SocialsData from './v-components/socials/Socials'
import CopyrightsData from './v-components/copyrights/Copyrights'

export default {
    components: {
        "v-language": LanguageData,
        "v-linksGroup": LinksGroupData,
        "v-socials": SocialsData,
        "v-copyrights": CopyrightsData,
    },
    props: {
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
            default: ""
        },
        socials: {
            type: String,
            required: false,
            default: ""
        },
        copyrights: {
            type: String,
            required: false,
            default: ""
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

<style lang="scss" scoped>
@import "./v-style/footer_default";
@import "./v-style/footer_media";
</style>