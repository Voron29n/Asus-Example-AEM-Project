<template>
<div :class="[this.blackVersion ? 'black-version' : 'white-version']">
    <div class="aai-inner">
        <div class="aai-fmiddle">
            <v-linksGroup :links-group-data="linksGroupData" :socials-data="socialsData"></v-linksGroup>
        </div>
        <div class="aai-fbootom">
            <v-language :language-data="languageData"></v-language>
            <v-copyrights :copyrights-data="copyrightsData"></v-copyrights>
        </div>
    </div>
        
</div>
</template>

<script>
import Footer_LanguageCmp from './v-components/language/Language'
import Footer_LinksGroupCmp from './v-components/linksGroup/LinksGroup'
import Footer_CopyrightsCmp from './v-components/copyrights/Copyrights'

export default {
    components: {
        "v-language": LanguageData,
        "v-linksGroup": LinksGroupData,
        "v-copyrights": CopyrightsData,
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
            document.querySelector('body footer').style.background = 
                this.blackVersion ? '#242424' : '#ECECEC' ;
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