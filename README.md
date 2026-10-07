# 云北城建 · 云筑工坊删减版（Yunbei Urban Construction / `yunbeiuc`）

> 本仓库是「云北城建」模组的**定制删减版**，专门为 **云筑工坊服务器** 提供。
> **移植与删减由 DeepSeek V4.1 完成；北咕仅负责模组核验。**
> 相对上游移除了路牌、道路方块、高速公路护栏、安全岛、道路花箱、自带图案库与交通字体等整块内容，
> 只保留**市政设施**一套系统与一个创造模式物品栏。

---

## ⚠️ 使用须知（clone 后必读）

- 本仓库为 **云筑工坊服务器定制**，**clone 后请务必修改模组信息**（模组名称 / ID / 作者 / 描述 / 仓库地址 / 版本号等），
  否则请勿直接分发或用于其它服务器。
- 需要修改的具体文件清单见 [第六节](#六clone-后必须修改的信息)。

---

## 项目信息

| 项 | 值 |
| --- | --- |
| 模组 ID | `yunbeiuc` |
| 版本 | `1.0.3-yunzhu` |
| Minecraft | `1.20.1` |
| 加载器 | `Fabric` / `Forge`（Architectury 多加载器） |
| 映射 | Mojang 官方映射（`loom.officialMojangMappings()`） |
| 许可 | MIT |
| 上游仓库 | <https://github.com/BGSDT/yunbei-urban-construction> |
| 本仓库 | <https://github.com/BGSDT/yunzhu-yunbei-urban-construction> |

**分工署名**

- **移植 / 删减**：DeepSeek V4.1
- **模组核验**：北咕

---

## 一、适用服务器与运行环境

本模组是**双端模组**（`fabric.mod.json` 中 `environment: "*"`，`mods.toml` 中 `side = "BOTH"`），
新增了方块、物品与网络包，因此 **服务端与客户端都必须安装同一版本**。

### 支持的加载器

| 平台 | 版本要求 | 必需前置 | 状态 |
| --- | --- | --- | --- |
| **Fabric** | Fabric Loader ≥ `0.15.11`，Minecraft `1.20.1` | Fabric API、Architectury API ≥ `9.2.14` | ✅ 支持 |
| **Forge** | Forge ≥ `47`（即 `1.20.1-47.x`），Minecraft `1.20.1` | Architectury API ≥ `9.2.14` | ✅ 支持 |

- **Java**：≥ `17`
- **客户端**：必须安装（含方块/物品注册、红绿灯与文字显示屏的渲染、GUI）。
- **服务端**：必须安装（方块、物品、网络包均在服务端注册）。

### 可运行的场景

- ✅ 单人游戏 / 局域网联机
- ✅ 原版 **Fabric 服务端**（fabric-loader）
- ✅ 原版 **Forge 服务端**
- ✅ 基于上述加载器的整合包 / 服务器（如 **云筑工坊服务器**）

### 不适用的场景

- ❌ 原版（Vanilla）服务端 —— 无法加载模组
- ❌ Paper / Spigot / Purpur 等**纯插件服务端** —— 不能加载 Forge/Fabric 模组
- ⚠️ 混合端（Mohist / Arclight / CatServer / Cardboard 等）—— 理论可加载，但本模组依赖
  Architectury 抽象层与客户端渲染/GUI，**混合端兼容性不作保证**，建议使用原版 Fabric/Forge 服务端

> **版本一致性**：服务端与客户端的模组版本必须一致，否则方块/物品注册与网络包会不匹配。

---

## 二、删减内容（本仓库相对上游移除的部分）

> 原则：删除**整块子系统**（Java 类 + 网络包 + 渲染器 + 注册类 + 资源文件），
> 而不仅是隐藏或禁用。

### 1. 路牌（独立路牌分类）

- **删除的 Java**：
  - 方块：`SignExpressway*`、`SignGuide*`、`ZonesBoard*`、`SignSimpleBlock`、
    `AbstractEditableSignBlock`（含 `…Reflective` / `…WithTooltip`）、`CustomSignTypeBlock`
  - 实体：`SignExpressway*`、`SignGuide*`、`ZonesBoard*`、`SignCompassDirection`、`SignTurnDirection`
  - 渲染：`SignExpressway*`、`SignGuide*`、`ZonesBoard*`、`SignType`、`SignTypeConverter`、
    `CustomSignBlockEntityRenderer`
  - 网络：`SignExpressway*`、`SignGuide*`、`ZonesBoard*`
  - 注册类：`block/SignBlocks`
- **保留**（属于市政设施）：路名牌 `road_name_sign_ra/rc/pole`、反光标志 `reflective_sign_*`、
  文字显示屏 `road_pole_text_display`

### 2. 道路方块

- 注册类 `block/RoadBlocks`
- `block/custom/road/*`（7 个）
- `DirectionBlock`、`DirectionSlabBlock`
- 地面标记模型 `models/block/ground_mark/` 及其贴图

### 3. 高速公路护栏

- `block/custom/guardrail/*`（4 个），含 `RoadClosedBarricadeGuardrail1 ~ 4`

### 4. 安全岛

- `block/custom/island/*`（3 个）：`SafetyIslandBlock`、`SafetyIslandEdgeBlock`、`SafetyIslandObliqueBlock`

### 5. 道路花箱

- `block/custom/box/*`（2 个）：`RoadFlowerBox1`、`RoadFlowerBox2Fence`

### 6. 自带图案库 / 交通字体 / 库界面

- **界面（整块删除）**：`PatternAndFontOverlay`、`PatternAndFontBlankScreen`、`PatternRegistry`、
  `GridRenderer`、`MouseEventHandler`、`HomepageRenderer`、`YunbeiUCIntegration`、
  `TextureAspectCache`、`SidebarState`、`PatternResourceLoader`
- **资源文件**：
  - `textures/block/sign/`、`textures/block/road/`、`textures/block/ground_mark/`
  - `models/block/sign/`、`models/block/road/`、`models/block/ground_mark/`
  - `font/`（`ds_digital.ttf`、`misans_semibold.ttf`、`re2014*.ttf`、`traf_sign_font_*.json`）
- **联动清理**：文字显示屏里的「图案」按钮、图案/字体浏览界面、输入事件转发与渲染转发均已移除；
  `LayoutHelper` 精简为通用几何工具，`UIConstants`/`PresetManager` 解除对图案库的依赖。

> **注意**：`traffic_lights_yunbeiuc.json`（红绿灯图案预设）**不在删减范围内，已保留**，
> 详见 [第三节「保留内容」](#三保留内容)。

### 7. 其余魔杖

- `TreeWand`（树木魔杖）、`WaterWand`（水域魔杖）、`RotatedWand`（旋转魔杖）

### 8. 创造模式物品栏

- **原**：道路方块 / 道路标识 / 魔杖工具 / 市政设施 —— 共 4 个
- **现**：只保留 **「市政设施」** 一个（`itemGroup.yunbeiuc.municipal`）

### 9. 资源清理统计

| 项目 | 清理前 | 清理后 |
| --- | --- | --- |
| blockstates | 149 | **141** |
| models/block | 320 | **311** |
| models/item | 202 | **144** |
| 语言键（`zh_cn` / `en_us`） | 1198 | **243** |
| 悬空纹理引用 | — | **0** |

---

## 三、保留内容

- **市政设施方块 141 个**：路杆、路灯、高杆灯、龙门架、红绿灯、护栏、隔离设施、减速带、
  振动标线、防撞桶、水马、反光锥、铁马、限高架、道闸、垃圾桶、声屏障、防眩网、警示网、
  防撞角、钉子带、升降柱、假路障、警示杆、标志牌、仪表设备等
- **红绿灯系统**：竖装/横装、单灯、雾灯、上海款、台北款、倒计时、人行道一体化、相位/时序编辑
- **红绿灯图案预设系统**（**完整保留**）：
  - `block/custom/traffic/TrafficLightsPatternPreset`
  - `util/TrafficLightsPatternPresetLoader`、`util/TrafficLightsPatternPresetManager`、
    `util/TrafficLightsPatternCategoryManager`
  - `screen/TrafficLightsPatternEditorScreen`、`TrafficLightsPatternSelectScreen`、
    `TrafficLightsPatternCategoryEditorScreen`、`TrafficLightsPatternCategorySelectScreen`
  - `network/TrafficLightsPatternApplyPacket`（`apply_traffic_lights_pattern` 网络包）
  - 内置预设数据：`assets/yunbeiuc/traffic_lights_yunbeiuc.json`
  - 入口：红绿灯界面中的「相位预设」按钮 → 分类选择 → 预设选择/编辑
- **3 个魔杖**：
  - 魔杖 `wand`（打开方块编辑界面）
  - 连接魔杖 `link_wand`（连接红绿灯组）
  - 文本复制魔杖 `text_copy_wand`
- **文字显示屏**：`road_pole_text_display`、`road_pole_led`、`gantry_frame_led`，
  含完整的文本编辑界面与**文本预设**（`PresetManager`，存档于游戏目录 `yunbeiuc_presets.json`）
- **路名牌 / 反光标志**
- **旗帜系统**：`flags_yunbeiuc.json` + `textures/block/flags/` 贴图
- **字体渲染基础设施**：`CustomFontRenderer`、`CustomFontManager`、`GlobalFontSettings`
  （被红绿灯 LED 与文字显示屏共用，故保留）

---

## 四、前置依赖

| 依赖 | Fabric | Forge |
| --- | --- | --- |
| Minecraft | `1.20.1` | `1.20.1` |
| 加载器 | Fabric Loader ≥ `0.15.11` | Forge ≥ `47` |
| Fabric API | 必需 | — |
| Architectury API | ≥ `9.2.14` | ≥ `9.2.14` |
| Java | ≥ `17` | ≥ `17` |
| ModMenu（可选） | ≥ `3.2.5` | — |

---

## 五、目录结构

```
versions/
├── common/                    # 跨版本共享源码（方块 / 物品 / 实体 / 网络 / 界面 / 资源）
│   └── src/main/
│       ├── java/com/beigu/yunbeiuc/
│       └── resources/assets/yunbeiuc/
└── 1.20.1/                    # 1.20.1 工程根（Gradle 根项目）
    ├── build.gradle           # 使用 loom.officialMojangMappings()
    ├── gradle.properties
    ├── common/                # 1.20.1 适配层（api/mapper、render、screen shim）
    ├── fabric/                # Fabric 入口与资源（fabric.mod.json）
    └── forge/                 # Forge 入口与资源（mods.toml）
```

- `versions/common` 不是独立 Gradle 模块，由 `versions/1.20.1/common/build.gradle` 通过
  `java.srcDir "$rootProject.projectDir/../common/src/main/java"` 挂载编译，
  因此构建 1.20.1 时必须同时带上 `versions/common`。

---

## 六、clone 后必须修改的信息

> 本仓库为 **云筑工坊服务器定制删减版**，直接 clone 使用前请按下表修改。

| 文件 | 需修改项 | 说明 |
| --- | --- | --- |
| `versions/1.20.1/gradle.properties` | `mod_version`、`archives_name`、`maven_group` | 版本号 / 产物名 / 包组 |
| `versions/1.20.1/fabric/src/main/resources/fabric.mod.json` | `id`、`name`、`description`、`authors`、`contact` | Fabric 模组元数据 |
| `versions/1.20.1/forge/src/main/resources/META-INF/mods.toml` | `modId`、`displayName`、`authors`、`description`、`issueTrackerURL`、`license` | Forge 模组元数据 |
| `versions/common/src/main/resources/assets/yunbeiuc/` | 资源命名空间目录名 | 若改模组 ID，需同步改资源目录 |
| `versions/*/**/icon.png` | 图标 | 三处（fabric / forge / 资源目录） |
| `versions/common/src/main/java/com/beigu/yunbeiuc/` | 包名 | 如需改包名，全仓库同步替换 |
| `README.md` | 本文件 | 仓库说明 |

> **改动模组 ID / 命名空间时务必全仓库同步替换**，否则注册表、资源路径与网络包会不匹配。

---

## 七、构建

> **必须使用 JDK 17**（Gradle 8.6 + Architectury Loom 1.5.391 在更高版本 JDK 上无法运行）。

```bash
cd versions/1.20.1

# Windows (Git Bash) / macOS / Linux
JAVA_HOME=/path/to/jdk-17 ./gradlew build
```

构建产物：

- Fabric：`versions/1.20.1/fabric/build/libs/yunbeiuc-fabric-1.0.3-yunzhu.jar`
- Forge：`versions/1.20.1/forge/build/libs/yunbeiuc-forge-1.0.3-yunzhu.jar`

若依赖已在本地缓存，可加 `--offline` 离线构建。

---

## 八、许可与链接

- **许可证**：MIT
- **上游仓库**：<https://github.com/BGSDT/yunbei-urban-construction>
- **本仓库**：<https://github.com/BGSDT/yunzhu-yunbei-urban-construction>
- **问题反馈**：<https://github.com/BGSDT/yunzhu-yunbei-urban-construction/issues>

**上游作者**：北咕、jstxjf_、潇湘-迷蝎、Tizhengxie、NanGuaQWQ、Yomi_307、FrostyHulan
**本仓库移植 / 删减**：DeepSeek V4.1　|　**模组核验**：北咕
