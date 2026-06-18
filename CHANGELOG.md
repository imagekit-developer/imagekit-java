# Changelog

## 3.3.0 (2026-06-18)

Full Changelog: [v3.2.0...v3.3.0](https://github.com/imagekit-developer/imagekit-java/compare/v3.2.0...v3.3.0)

### Features

* **origins:** add useIAMRole for IAM role authentication ([621b8b9](https://github.com/imagekit-developer/imagekit-java/commit/621b8b9c981f03458c836ba5fc167cd77d70b008))


### Documentation

* update default value in description for intensity in colorize transformation ([b7bae14](https://github.com/imagekit-developer/imagekit-java/commit/b7bae14adf3219aac909605d951a37e991d0ff8d))

## [3.2.0](https://github.com/imagekit-developer/imagekit-java/compare/v3.1.2...v3.2.0) (2026-06-03)


### Bug Fixes

* metadata response shape ([2064e1a](https://github.com/imagekit-developer/imagekit-java/commit/2064e1a12d6d20d71d0921bf1bb4b3e40be9f520))


### Chores

* pin next release ([4c20da0](https://github.com/imagekit-developer/imagekit-java/commit/4c20da05e894b647b8e4cb81f5613dd1d7b916a0))

## [3.1.2](https://github.com/imagekit-developer/imagekit-java/compare/v3.1.1...v3.1.2) (2026-05-25)


### Features

* initial stlc build ([9418324](https://github.com/imagekit-developer/imagekit-java/commit/941832443279b45ffdab0ff5a440fc19b1904aa4))


### Chores

* pin next release ([537e748](https://github.com/imagekit-developer/imagekit-java/commit/537e7488b778bfdfc543b9b876dd5faf6bfea53c))
* Update webhook description ([9e5cc4b](https://github.com/imagekit-developer/imagekit-java/commit/9e5cc4bc6da2ffe1ecfc8993465a502c2716451e))
* Update webhook description ([3859bd4](https://github.com/imagekit-developer/imagekit-java/commit/3859bd4f87124025eb99bcc19fbaaacc78713852))

## 3.1.1 (2026-05-17)

Full Changelog: [v3.1.0...v3.1.1](https://github.com/imagekit-developer/imagekit-java/compare/v3.1.0...v3.1.1)

### Build System

* **dotnet:** adding variant name for build warnings cannot infer union variant name ([ede45e2](https://github.com/imagekit-developer/imagekit-java/commit/ede45e238c23ec07bd5c9209d81645636b9e1892))
* revert dotnet specific changes ([a2059aa](https://github.com/imagekit-developer/imagekit-java/commit/a2059aad80d79249bd66492a063c0358421c391b))

## 3.1.0 (2026-05-13)

Full Changelog: [v3.0.0...v3.1.0](https://github.com/imagekit-developer/imagekit-java/compare/v3.0.0...v3.1.0)

### Features

* **api:** add no-enlarge crop modes and colorize transformation ([183b131](https://github.com/imagekit-developer/imagekit-java/commit/183b131e263f5d3958317b867011349ebd0820ae))
* **client:** improve logging ([a62b5e3](https://github.com/imagekit-developer/imagekit-java/commit/a62b5e30077bab50d3a9764daa7c520df18914bb))
* **client:** more robust error parsing ([8e42517](https://github.com/imagekit-developer/imagekit-java/commit/8e4251712d721a17b9caa4f1ad04e9c2c06822a0))
* **client:** support proxy authentication ([60effd3](https://github.com/imagekit-developer/imagekit-java/commit/60effd33a60b70e3f44e9180927e3a63a93ee00d))
* **helper:** add colorize transformation support in URL generation ([209a37c](https://github.com/imagekit-developer/imagekit-java/commit/209a37cb5547b1875b8b0b39b54c674d527a3e87))
* support setting headers via env ([c31a472](https://github.com/imagekit-developer/imagekit-java/commit/c31a472fd2674c2e339d16024cb47bf246994a38))


### Performance Improvements

* **client:** create one json mapper ([92128db](https://github.com/imagekit-developer/imagekit-java/commit/92128db5fbd82870290b9c1b5003115dd7c04469))


### Chores

* redact api-key headers in debug logs ([8db78f2](https://github.com/imagekit-developer/imagekit-java/commit/8db78f2751eb396a6f418e63631c22ecddbafb8c))
* remove duplicated dokka setup ([a1a0ece](https://github.com/imagekit-developer/imagekit-java/commit/a1a0ece2a2e02b2dc10b6bee8d043170e3cd9681))


### Documentation

* clarify forwards compat behavior ([d5ec8cf](https://github.com/imagekit-developer/imagekit-java/commit/d5ec8cffa3ebac99d70f70f7b6c4fadbe042a5be))

## 3.0.0 (2026-04-21)

Full Changelog: [v0.0.1...v3.0.0](https://github.com/imagekit-developer/imagekit-java/compare/v0.0.1...v3.0.0)

### Features

* add helper utilities and lib module with tests ([92fb768](https://github.com/imagekit-developer/imagekit-java/commit/92fb768157a6630a3770f5ad99596b6c3ed184f3))
* **api:** add BaseWebhookEvent ([4ab06b0](https://github.com/imagekit-developer/imagekit-java/commit/4ab06b01316b114e526159de348b9d52fdd57567))
* **api:** add customMetadata property to folder schema ([0413e64](https://github.com/imagekit-developer/imagekit-java/commit/0413e64aa737500a42764fb2613f94cf582cb2b8))
* **api:** add GetImageAttributesOptions and ResponsiveImageAttributes schemas; update resource references in main.yaml; remove dummy endpoint ([70d2551](https://github.com/imagekit-developer/imagekit-java/commit/70d2551ec48038eb1deb0459a0b4dc2b6506c837))
* **api:** add path policy related non-breaking changes ([6e2eac3](https://github.com/imagekit-developer/imagekit-java/commit/6e2eac363b8f707a58009f6812350f45d4856da2))
* **api:** Add saved extensions API and enhance transformation options ([1bca614](https://github.com/imagekit-developer/imagekit-java/commit/1bca6144095239ef2892cd989f89136e4af1a953))
* **api:** add selectedFieldsSchema in upload and list API response ([34289ae](https://github.com/imagekit-developer/imagekit-java/commit/34289ae2c42a258e56ad87133c9eff209b248163))
* **api:** add webhook signature verification ([ff73a7a](https://github.com/imagekit-developer/imagekit-java/commit/ff73a7abfc250eb2558c073684d328a48b9df29e))
* **api:** dam related webhook events ([8352cba](https://github.com/imagekit-developer/imagekit-java/commit/8352cbaa2184947c142175d475c2cc06c9e9f57f))
* **api:** dpr type update ([6a528ff](https://github.com/imagekit-developer/imagekit-java/commit/6a528ff9db3c2123c79997bd48b503be731cca65))
* **api:** extract UpdateFileDetailsRequest to model ([c75a767](https://github.com/imagekit-developer/imagekit-java/commit/c75a767180e2d032fc0ab1d2fe74e41795bd957d))
* **api:** fix spec indentation ([26eba98](https://github.com/imagekit-developer/imagekit-java/commit/26eba981e412103f0293fafd8888e3d075deec0d))
* **api:** fix upload API request params ([7abe230](https://github.com/imagekit-developer/imagekit-java/commit/7abe23093ccf53fcf4b0829cc7d4b792cf8c4406))
* **api:** indentation fix ([0caeef8](https://github.com/imagekit-developer/imagekit-java/commit/0caeef861804c31031de369a40e0ac755ff26396))
* **api:** Introduce lxc, lyc, lap parameters in overlays. ([e3b34fb](https://github.com/imagekit-developer/imagekit-java/commit/e3b34fb41f580c5bd557c99cc7c26af6d5583b20))
* **api:** manual updates ([afb90e6](https://github.com/imagekit-developer/imagekit-java/commit/afb90e655bbe37ba25e2cb3f02577414483c3488))
* **api:** manual updates ([b586d51](https://github.com/imagekit-developer/imagekit-java/commit/b586d513361b7ed938fb9a4c29a44a9e47e1cca2))
* **api:** manual updates ([75ff27c](https://github.com/imagekit-developer/imagekit-java/commit/75ff27c3c8a2c90d7bf5d14e75b1e3de05733781))
* **api:** manual updates ([646022d](https://github.com/imagekit-developer/imagekit-java/commit/646022de6d3820653968a99867c60b3df998f9d3))
* **api:** manual updates ([f5206be](https://github.com/imagekit-developer/imagekit-java/commit/f5206beb4c997de9c2ff47a70d36795557fae7c5))
* **api:** manual updates ([e474ef2](https://github.com/imagekit-developer/imagekit-java/commit/e474ef2004c784def6eba33158337511c073d178))
* **api:** manual updates ([09a68d6](https://github.com/imagekit-developer/imagekit-java/commit/09a68d6fb594866ed049c11cba27d797ef553908))
* **api:** manual updates ([e01a75a](https://github.com/imagekit-developer/imagekit-java/commit/e01a75a9df1f6f49754095c9b61159236b5658b5))
* **api:** manual updates ([2d41187](https://github.com/imagekit-developer/imagekit-java/commit/2d41187dea1edca9d0f941690244b4c50874d9cc))
* **api:** manual updates ([2ef93ad](https://github.com/imagekit-developer/imagekit-java/commit/2ef93ad3db97af5fef99687a4438c76e2220b384))
* **api:** manual updates ([c6e61f8](https://github.com/imagekit-developer/imagekit-java/commit/c6e61f8ca6b3a9485ab15d0221842ef76b6cae32))
* **api:** manual updates ([1c76234](https://github.com/imagekit-developer/imagekit-java/commit/1c762344ee41aa7099febdca72f368943ee8428b))
* **api:** manual updates ([cd2b64e](https://github.com/imagekit-developer/imagekit-java/commit/cd2b64ef8d6324264a71321bb11a7849260d98fc))
* **api:** manual updates ([1341b62](https://github.com/imagekit-developer/imagekit-java/commit/1341b6282b4a32013cb60f11ee0ec9aaef8acac4))
* **api:** manual updates ([83ce070](https://github.com/imagekit-developer/imagekit-java/commit/83ce0707ff45a9daa97e12daa9ad050dcbab53f9))
* **api:** manual updates ([d57885b](https://github.com/imagekit-developer/imagekit-java/commit/d57885b731de1837a7edcd3f6eab303db855475a))
* **api:** manual updates ([74027ef](https://github.com/imagekit-developer/imagekit-java/commit/74027efe9095a5e650addddf064d6e3773413894))
* **api:** manual updates ([76c5b5e](https://github.com/imagekit-developer/imagekit-java/commit/76c5b5e1fbc0ac3415d5e35febce642dd47cd0ab))
* **api:** manual updates ([b462410](https://github.com/imagekit-developer/imagekit-java/commit/b46241040326016adf4ad220178ccf3221323f90))
* **api:** manual updates ([cbbd424](https://github.com/imagekit-developer/imagekit-java/commit/cbbd424da5ebd388dd6e3d8af7e38b7633ed0604))
* **api:** merge with main to bring back missing parameters ([fb7f512](https://github.com/imagekit-developer/imagekit-java/commit/fb7f512d8932eb43656a89fdce6ccc8f59b3ebb6))
* **api:** remove Stainless attribution from readme ([065125f](https://github.com/imagekit-developer/imagekit-java/commit/065125f9c510b69c6ec41ddb811f9cebcdd37c1b))
* **api:** revert dpr breaking change ([997ab63](https://github.com/imagekit-developer/imagekit-java/commit/997ab6353eeb46a8b97cad9f9688a11b9d700fc3))
* **api:** update api docs link ([0b273a9](https://github.com/imagekit-developer/imagekit-java/commit/0b273a981219fbf9083fcb2559d81f3e472ca9e1))
* **api:** Update env var name ([1b520d1](https://github.com/imagekit-developer/imagekit-java/commit/1b520d13de7c42693d3acc4a364fdec55eb341ce))
* **api:** update webhook event names and remove DAM prefix ([0cbbc63](https://github.com/imagekit-developer/imagekit-java/commit/0cbbc63ad53db27fae27e4b0f470b3242d8bdaeb))
* **client:** add `HttpRequest#url()` method ([fa1b9b7](https://github.com/imagekit-developer/imagekit-java/commit/fa1b9b7159b51b86831440ba956082f3d2619c37))
* **client:** add connection pooling option ([c7a7295](https://github.com/imagekit-developer/imagekit-java/commit/c7a72959cf29e796657dea8d7590f4b96d5fb542))
* **client:** add more convenience service method overloads ([f462bff](https://github.com/imagekit-developer/imagekit-java/commit/f462bfff56865ae16dadb5a404c696d3d5ff1ff9))
* **client:** allow configuring dispatcher executor service ([a7be5ce](https://github.com/imagekit-developer/imagekit-java/commit/a7be5cec994774da7ba3c6129e63d13686d065c9))
* **client:** send `X-Stainless-Kotlin-Version` header ([2224a12](https://github.com/imagekit-developer/imagekit-java/commit/2224a1264e0fd8772808873c4978b7930f0acb4b))


### Bug Fixes

* add ai-tasks property to response schemas with enum values ([b0bfdf6](https://github.com/imagekit-developer/imagekit-java/commit/b0bfdf6c142e23170be4051a985d7206c74f5958))
* add one more method in multipartbuilder to build from json ([9dc2f89](https://github.com/imagekit-developer/imagekit-java/commit/9dc2f897ec7b9a1998d283359472b882cfb9ee68))
* **api:** add missing embeddedMetadata and video properties to FileDetails ([ceb43dd](https://github.com/imagekit-developer/imagekit-java/commit/ceb43ddf46ac19fc90fb28e716d6f5490630bc30))
* **api:** extract shared schemas to prevent Go webhook union breaking changes ([f5fdf8f](https://github.com/imagekit-developer/imagekit-java/commit/f5fdf8fd7cc5a0f70fef28fd8b1fc23ebda05c8c))
* **api:** rename DamFile events to File for consistency ([f18e22b](https://github.com/imagekit-developer/imagekit-java/commit/f18e22be52528874c7adb453bc360b0e511001c3))
* **ci:** use java-version 21 for publish step ([181fbe5](https://github.com/imagekit-developer/imagekit-java/commit/181fbe5360fbc5820cb9df684d242896ec146049))
* **client:** allow updating header/query affecting fields in `toBuilder()` ([91e327e](https://github.com/imagekit-developer/imagekit-java/commit/91e327e82db972ae6e5a50f9fb14e52ead007621))
* **client:** cancel okhttp call when future cancelled ([d4b8c84](https://github.com/imagekit-developer/imagekit-java/commit/d4b8c848066b410e35a95c555bc238f8e5228b83))
* **client:** deserialization of empty objects ([8ccff9b](https://github.com/imagekit-developer/imagekit-java/commit/8ccff9bc6b39dbd306eb5325a830bbadc0053585))
* **client:** disallow coercion from float to int ([a6dc3e2](https://github.com/imagekit-developer/imagekit-java/commit/a6dc3e26f63b2b3c2d5a8185c329f5140f84076d))
* **client:** fully respect max retries ([87d2ad3](https://github.com/imagekit-developer/imagekit-java/commit/87d2ad3db0d0730371b5f814dd5a14c2c0ab0ee0))
* **client:** incorrect `getPackageVersion` impl ([078eab8](https://github.com/imagekit-developer/imagekit-java/commit/078eab8cf903109aaead3f0e90a2ee0b14c9c9ce))
* **client:** incorrect `Retry-After` parsing ([15b04f7](https://github.com/imagekit-developer/imagekit-java/commit/15b04f7bfb7677c941dda5db230b273115551600))
* **client:** multi-value header serialization ([ccb0ffb](https://github.com/imagekit-developer/imagekit-java/commit/ccb0ffb22b5a6ce7789110fa3d83e42a279fcb22))
* **client:** preserve time zone in lenient date-time parsing ([3c1ce69](https://github.com/imagekit-developer/imagekit-java/commit/3c1ce699ab55a45358fc78b2437ca1971c6918ea))
* **client:** send retry count header for max retries 0 ([87d2ad3](https://github.com/imagekit-developer/imagekit-java/commit/87d2ad3db0d0730371b5f814dd5a14c2c0ab0ee0))
* date time deserialization leniency ([7f3e0d6](https://github.com/imagekit-developer/imagekit-java/commit/7f3e0d6f67a4e7b598ef2763d81faff8e00b9959))
* deserialization order ([a7d3f1e](https://github.com/imagekit-developer/imagekit-java/commit/a7d3f1e74b0cd489ed67458efe462996b2706e50))
* **docs:** fix mcp installation instructions for remote servers ([2a727d4](https://github.com/imagekit-developer/imagekit-java/commit/2a727d401b4dff5441414b565ba081822a737926))
* fix request delays for retrying to be more respectful of high requested delays ([eb80ae5](https://github.com/imagekit-developer/imagekit-java/commit/eb80ae59186571723c253602ebf87e31bc52b988))
* vocab field is required ([ea9bfc3](https://github.com/imagekit-developer/imagekit-java/commit/ea9bfc30c34316aca3f1536e366b920e7e9c8bb7))


### Chores

* **ci:** skip lint on metadata-only changes ([f43fd3a](https://github.com/imagekit-developer/imagekit-java/commit/f43fd3ae0642cc33b727775e62eb58a6fb3f0123))
* **ci:** skip uploading artifacts on stainless-internal branches ([19e8f78](https://github.com/imagekit-developer/imagekit-java/commit/19e8f78f7ee6e65ad0943dcccc7e17af31cf074c))
* **ci:** upgrade `actions/github-script` ([940ebfc](https://github.com/imagekit-developer/imagekit-java/commit/940ebfcf3a2153e86b2292f2ca6077874d9fb170))
* **ci:** upgrade `actions/setup-java` ([e60fd58](https://github.com/imagekit-developer/imagekit-java/commit/e60fd58b5a303ea126c427f046fc30c0c63bfa79))
* configure new SDK language ([4c0fdb3](https://github.com/imagekit-developer/imagekit-java/commit/4c0fdb3884cf537b504527a651790546eb645210))
* drop apache dependency ([48e02f7](https://github.com/imagekit-developer/imagekit-java/commit/48e02f702dea5f4c0553740e48bd670c63477f51))
* improve formatter performance ([daaa7f3](https://github.com/imagekit-developer/imagekit-java/commit/daaa7f33c20310093952bd4396d305bef42c81b8))
* **internal:** allow passing args to `./scripts/test` ([1d14a59](https://github.com/imagekit-developer/imagekit-java/commit/1d14a5930b16ce47c2f85e2e5e8b2507dec9a61f))
* **internal:** bump palantir-java-format ([87b5f18](https://github.com/imagekit-developer/imagekit-java/commit/87b5f1817dda7429a6b4a154f71d4196198df0c0))
* **internal:** change some comment formatting ([86ca3d7](https://github.com/imagekit-developer/imagekit-java/commit/86ca3d7d9676b6a07f1930195a8dd5dacf12714a))
* **internal:** clean up maven repo artifact script and add html documentation to repo root ([8e34e08](https://github.com/imagekit-developer/imagekit-java/commit/8e34e08c8aa939a06b933c0c29c0df46b175b8c2))
* **internal:** codegen related update ([e970882](https://github.com/imagekit-developer/imagekit-java/commit/e970882efd7aa0f4770edce814c9b837e8ae247c))
* **internal:** codegen related update ([da02221](https://github.com/imagekit-developer/imagekit-java/commit/da0222197fca08583b2096effa2bd18a9f9f615b))
* **internal:** codegen related update ([814caf9](https://github.com/imagekit-developer/imagekit-java/commit/814caf9f6454c4b32af76f3a5b68d6af54d631b3))
* **internal:** codegen related update ([cd82f98](https://github.com/imagekit-developer/imagekit-java/commit/cd82f981b54a9131ed8195f62de0bb65bb436b6d))
* **internal:** codegen related update ([da788af](https://github.com/imagekit-developer/imagekit-java/commit/da788af79c52a70075f39b26776b203cd958ceb0))
* **internal:** codegen related update ([f25c3c4](https://github.com/imagekit-developer/imagekit-java/commit/f25c3c46f4104091a5e8e376c22727eb3aaa4611))
* **internal:** correct cache invalidation for `SKIP_MOCK_TESTS` ([1f6f1dc](https://github.com/imagekit-developer/imagekit-java/commit/1f6f1dcfb312298c1cbb524512d0a8aa7e05560e))
* **internal:** depend on packages directly in example ([87d2ad3](https://github.com/imagekit-developer/imagekit-java/commit/87d2ad3db0d0730371b5f814dd5a14c2c0ab0ee0))
* **internal:** expand imports ([f10c1b0](https://github.com/imagekit-developer/imagekit-java/commit/f10c1b040943402094e0f75669b0eb61503d9875))
* **internal:** improve examples ([998d126](https://github.com/imagekit-developer/imagekit-java/commit/998d126b14aebc0a454a15d9169049888395ec35))
* **internal:** improve maven repo docs ([b92f5f0](https://github.com/imagekit-developer/imagekit-java/commit/b92f5f0ea9c1defd19ed0224471dc6cd2bed2e2e))
* **internal:** make `OkHttp` constructor internal ([534feb3](https://github.com/imagekit-developer/imagekit-java/commit/534feb30f3c327e09d1e13423e447224e2da90d7))
* **internal:** remove mock server code ([3f1d1c6](https://github.com/imagekit-developer/imagekit-java/commit/3f1d1c67caa0d9824d3c03bef1c8b58a5d58c76e))
* **internal:** remove redundant deserializer symbols ([2d52469](https://github.com/imagekit-developer/imagekit-java/commit/2d52469a65c898504a76adb6ab4826aa3febbbdc))
* **internal:** remove unnecessary base URL ([98d50fa](https://github.com/imagekit-developer/imagekit-java/commit/98d50fa72841ab2a4fe4baf62861f4c2e911a23b))
* **internal:** support uploading Maven repo artifacts to stainless package server ([83de2bf](https://github.com/imagekit-developer/imagekit-java/commit/83de2bfb62facd417c3cd626c0f3a7ed7e989165))
* **internal:** tweak CI branches ([3e76397](https://github.com/imagekit-developer/imagekit-java/commit/3e76397ba5582f39d56aeb243d2fa81564814604))
* **internal:** update `actions/checkout` version ([7115c38](https://github.com/imagekit-developer/imagekit-java/commit/7115c3879f8983659e87b369a23600d4c2ae9646))
* **internal:** update `TestServerExtension` comment ([89b8598](https://github.com/imagekit-developer/imagekit-java/commit/89b85982f5be8ac9de8b4ea05a6ca0490951f21b))
* **internal:** update gitignore ([4c944e0](https://github.com/imagekit-developer/imagekit-java/commit/4c944e0804b949085602a5d724120ab40acba53d))
* **internal:** update maven repo doc to include authentication ([7156f6f](https://github.com/imagekit-developer/imagekit-java/commit/7156f6fa1a10aa4d4cd1655d2a3612239fc25422))
* **internal:** update multipart form array serialization ([11184c7](https://github.com/imagekit-developer/imagekit-java/commit/11184c77fbc86d278f2791bdbbfcaa1cb542eaae))
* **internal:** update retry delay tests ([51a3135](https://github.com/imagekit-developer/imagekit-java/commit/51a3135751d0ff2bdc2c741e714061615d232b7b))
* **internal:** upgrade AssertJ ([99a48d6](https://github.com/imagekit-developer/imagekit-java/commit/99a48d6896e90c14b96e182b85692a7f1b6aece7))
* make `Properties` more resilient to `null` ([34b930a](https://github.com/imagekit-developer/imagekit-java/commit/34b930ad491dafb8e94442ef07864d47d1f54137))
* remove custom code ([ec944a0](https://github.com/imagekit-developer/imagekit-java/commit/ec944a0fafc93f26bc277530738901258e787bb1))
* sync repo ([05af7d5](https://github.com/imagekit-developer/imagekit-java/commit/05af7d57aab0174c720f1dd71e87d39f1197bfa1))
* test on Jackson 2.14.0 to avoid encountering FasterXML/jackson-databind[#3240](https://github.com/imagekit-developer/imagekit-java/issues/3240) in tests ([7f3e0d6](https://github.com/imagekit-developer/imagekit-java/commit/7f3e0d6f67a4e7b598ef2763d81faff8e00b9959))
* **tests:** bump steady to v0.19.4 ([3b0fc2e](https://github.com/imagekit-developer/imagekit-java/commit/3b0fc2efe92fcf1733f4bbdefe779cd2203e585a))
* **tests:** update webhook tests ([2f221f7](https://github.com/imagekit-developer/imagekit-java/commit/2f221f7678f232232a18d3b533bbeb93a7758599))
* update mock server docs ([6fb3f0c](https://github.com/imagekit-developer/imagekit-java/commit/6fb3f0cfd3a1f8bb17c9c632c56db7f5a7240948))
* update placeholder string ([6b3d9f5](https://github.com/imagekit-developer/imagekit-java/commit/6b3d9f5c59f9e416ea67380045bf54ef9f48f135))
* update SDK settings ([b39e9dc](https://github.com/imagekit-developer/imagekit-java/commit/b39e9dc8e9af7806353b5f9276f023fec45c5905))
* update SDK settings ([00f7055](https://github.com/imagekit-developer/imagekit-java/commit/00f705596f585c9020a4620a9675e733f28b8b1b))


### Documentation

* correct typo in default value description for custom metadata field ([fc00907](https://github.com/imagekit-developer/imagekit-java/commit/fc00907646fa9bfb333ac303783d58956cc262c2))
* improve examples ([f9a78b0](https://github.com/imagekit-developer/imagekit-java/commit/f9a78b0fd65f309da64d400d91665696ebfb67eb))
* prominently feature MCP server setup in root SDK readmes ([41bf700](https://github.com/imagekit-developer/imagekit-java/commit/41bf7009b03948c41ffd933a80ee0ffea1a7a00b))
* remove `$` for better copy-pasteabality ([2273b04](https://github.com/imagekit-developer/imagekit-java/commit/2273b04035285050a65b6703e523789905d71387))


### Refactors

* AITags to singular AITag schema with array items pattern ([e71dfe1](https://github.com/imagekit-developer/imagekit-java/commit/e71dfe138309b105b1eb38d5622e21f147446571))


### Build System

* updating CI ([a14b7cc](https://github.com/imagekit-developer/imagekit-java/commit/a14b7cc70204cd8af648e3c3ac7664f3916850b1))
